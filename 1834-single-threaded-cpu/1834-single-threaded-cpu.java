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
        PriorityQueue<int[]> availableTasks = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                if(a[1] == b[1])
                {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
        });
        int currentTime = 0;
        int processed = 0;
        idx = 0;
        int[] ans = new int[numTasks];
        while(processed < numTasks)
        {
            // some idle time to be spent by CPU until the next task becomes available
            if(availableTasks.size() == 0)
            {
                currentTime = indexedTasks[idx][0];
            }
            else
            {
                int[] top = availableTasks.poll();
                ans[processed] = top[2];
                currentTime += top[1];
                processed++;
            }
            // if the else block executes and some other tasks got available during the execution of the last task, then we should add them. Whereas, If the 'if' block was executed, we will still need to add all the eligible tasks to the queue for them to be available for processing
            while(idx < numTasks && indexedTasks[idx][0] <= currentTime)
            {
                availableTasks.add(indexedTasks[idx]);
                idx++;
            }
        }
        return ans;
    }
}