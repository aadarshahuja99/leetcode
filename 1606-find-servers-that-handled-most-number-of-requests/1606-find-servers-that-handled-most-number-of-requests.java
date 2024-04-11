class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // a single priority quueue should be enough
        PriorityQueue<int[]> serverStatus = new PriorityQueue<int[]>((a,b) -> {
            // 0:time, 1:index
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        TreeSet<Integer> available = new TreeSet<>();
        HashMap<Integer,Integer> requestCounts = new HashMap<>();
        for(int i=0; i<k; i++)
        {
            available.add(i);
            requestCounts.put(i,0);
        }
        int maxRequests = 0;
        
        int numTasks = arrival.length;
        for(int i=0; i<numTasks; i++)
        {
            int currentLoad = load[i];
            int currentArrival = arrival[i];
            while(serverStatus.size() > 0 && serverStatus.peek()[0] <= currentArrival)
            {
                int[] server = serverStatus.poll();
                available.add(server[1]);
            }
            if(available.size() == 0)
            {
                continue;
            }
            if(available.contains(i%k))
            {
                available.remove(i%k);
                serverStatus.add(new int[] { currentLoad + currentArrival, i%k });
                requestCounts.put(i%k, requestCounts.get(i%k) + 1);
                maxRequests = Math.max(maxRequests, requestCounts.get(i%k));
            }
            else
            {
                Integer ceil = available.ceiling(i%k);
                if(ceil != null)
                {
                    // find the next available higher entry in set
                    available.remove(ceil);
                    serverStatus.add(new int[] { currentLoad + currentArrival, ceil });
                    requestCounts.put(ceil, requestCounts.get(ceil) + 1);
                    maxRequests = Math.max(maxRequests, requestCounts.get(ceil));
                }
                else
                {
                    // check for the first entry in set (wrapping around)
                    Integer floor = available.first();
                    serverStatus.add(new int[] { currentLoad + currentArrival, floor });
                    requestCounts.put(floor, requestCounts.get(floor) + 1);
                    maxRequests = Math.max(maxRequests, requestCounts.get(floor));
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry : requestCounts.entrySet())
        {
            if(entry.getValue() == maxRequests)
            {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}