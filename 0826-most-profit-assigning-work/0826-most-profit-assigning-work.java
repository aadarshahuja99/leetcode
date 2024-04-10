class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        int numJobs = difficulty.length;
        int numWorkers = workers.length;
        int[][] jobs = new int[numJobs][2];
        for(int i=0; i<numJobs; i++)
        {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a,b) -> {
            return a[0] - b[0];
        });
        int[] maxProfit = new int[numJobs];
        maxProfit[0] = jobs[0][1];
        int max = jobs[0][1];
        for(int i=1; i<numJobs; i++)
        {
            max = Math.max(max, jobs[i][1]);
            maxProfit[i] = max;
        }
        int ans = 0;
        for(int worker : workers)
        {
            int start = 0;
            int end = numJobs-1;
            int j = -1;
            while(start <= end)
            {
                int mid = start + (end-start)/2;
                if(jobs[mid][0] <= worker)
                {
                    j = mid;
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
            if(j == -1)
            {
                continue;
            }
            int p = maxProfit[j];
            // System.out.println(p+" for "+worker);
            ans += p;
        }
        return ans;
    }
}