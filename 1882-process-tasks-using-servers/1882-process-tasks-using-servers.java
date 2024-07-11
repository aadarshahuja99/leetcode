class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<long[]> serverPq = new PriorityQueue<long[]>(new Comparator<long[]>() {
            public int compare(long[] a, long[] b)
            {
                // 0: wt, 1: idx
                if(a[0] == b[0])
                {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[0], b[0]);
            }
        });
        PriorityQueue<long[]> occupiedServers = new PriorityQueue<long[]>(new Comparator<long[]>() {
            public int compare(long[] a, long[] b)
            {
                if(a[2] == b[2])
                {
                    // 0: wt, 1: idx
                    if(a[0] == b[0])
                    {
                        return Long.compare(a[1], b[1]);
                    }
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[2], b[2]);
            }
        });
        int idx = 0;
        for(int server : servers)
        {
            serverPq.add(new long[] { server, idx, 0 });
            idx++;
        }
        int numTasks = tasks.length;
        int[] assignedServers = new int[numTasks];
        int taskIndex = 0;
        while(taskIndex < numTasks)
        {
            int current = tasks[taskIndex];
            while(occupiedServers.size() > 0 && taskIndex >= occupiedServers.peek()[2])
            {
                long[] occupiedServer = occupiedServers.poll();
                serverPq.add(occupiedServer);
            }

            if(serverPq.size() > 0)
            {
                var top = serverPq.poll();
                assignedServers[taskIndex] = (int)top[1];
                // System.out.println((taskIndex + current));
                occupiedServers.add(new long[] { top[0], top[1], taskIndex + current });
                taskIndex++;
            }
            else
            {
                var top = occupiedServers.poll();
                assignedServers[taskIndex] = (int)top[1];
                // System.out.println((top[2] + current));
                occupiedServers.add(new long[] { top[0], top[1], top[2] + current });
                taskIndex++;
            }
        }
        return assignedServers;
    }
}