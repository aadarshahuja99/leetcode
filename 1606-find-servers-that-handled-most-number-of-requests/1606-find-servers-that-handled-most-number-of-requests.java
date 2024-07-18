class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // a single priority queue should be enough
        PriorityQueue<int[]> serverStatus = new PriorityQueue<int[]>((a,b) -> {
            // 0:time, 1:index
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        TreeSet<Integer> available = new TreeSet<>();
        int[] requestCounts = new int[k];
        for(int i=0; i<k; i++)
        {
            available.add(i);
        }
        int maxRequests = 0;
        
        int numTasks = arrival.length;
        for(int i=0; i<numTasks; i++)
        {
            int currentLoad = load[i];
            int currentArrival = arrival[i];
            // free up all the servers that are ready to be free by the arrival of the current request
            while(serverStatus.size() > 0 && serverStatus.peek()[0] <= currentArrival)
            {
                int[] server = serverStatus.poll();
                available.add(server[1]);
            }
            // if all occupied, the current request is dropped
            if(available.size() == 0)
            {
                continue;
            }
            // process the request as per the rules
            if(available.contains(i%k))
            {
                available.remove(i%k);
                serverStatus.add(new int[] { currentLoad + currentArrival, i%k });
                requestCounts[i%k]++;
                maxRequests = Math.max(maxRequests, requestCounts[i%k]);
            }
            else
            {
                Integer ceil = available.ceiling(i%k);
                if(ceil != null)
                {
                    // find the next available higher entry in set
                    available.remove(ceil);
                    serverStatus.add(new int[] { currentLoad + currentArrival, ceil });
                    requestCounts[ceil]++;
                    maxRequests = Math.max(maxRequests, requestCounts[ceil]);
                }
                else
                {
                    // check for the first entry in set (wrapping around)
                    Integer floor = available.first();
                    available.remove(floor);
                    serverStatus.add(new int[] { currentLoad + currentArrival, floor });
                    requestCounts[floor]++;
                    maxRequests = Math.max(maxRequests, requestCounts[floor]);
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<k; i++)
        {
            if(requestCounts[i] == maxRequests)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}