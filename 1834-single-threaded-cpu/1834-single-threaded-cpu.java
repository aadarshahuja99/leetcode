class Solution {
    public int[] getOrder(int[][] tasks) {
        int numTasks = tasks.length;
        int[][] indexedTasks = new int[numTasks][3];
        int idx = 0;
        for(int[] task : tasks)
        {
            indexedTasks[idx] = new int[] { task[0], task[1], idx };
            idx++;
        }
        Arrays.sort(indexedTasks, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                if(a[1] == b[1])
                {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
        });
        // for(int[] task : indexedTasks)
        // {
        //     System.out.println(task[0]+" "+task[1]+" "+task[2]);
        // }
        int minTime = indexedTasks[0][0];
        idx = 0;
        for(int i=0; i<numTasks; i++)
        {
            if(indexedTasks[i][0] != minTime)
            {
                break;
            }
            // System.out.println("adding "+indexedTasks[i][2]+" to the pq");
            pq.add(indexedTasks[i]);
            idx++;
        }
        int currentTime = minTime;
        int processed = 0;
        int[] ans = new int[numTasks];
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            // System.out.println("polled: "+top[0]+" "+top[1]+" "+top[2]+" currentTime: "+currentTime);
            ans[processed] = top[2];
            currentTime = top[1] + currentTime;
            if(pq.size() == 0 && idx < numTasks && indexedTasks[idx][0] > currentTime)
            {
                currentTime = indexedTasks[idx][0];
                System.out.println(indexedTasks[idx][2]+" "+currentTime);
                pq.add(indexedTasks[idx]);
                idx++;
            }
            while(idx < numTasks && indexedTasks[idx][0] <= currentTime)
            {
                // System.out.println("adding "+indexedTasks[idx][2]+" to the pq");
                pq.add(indexedTasks[idx]);
                idx++;
            }
            // System.out.println();
            processed++;
        }
        return ans;
    }
}