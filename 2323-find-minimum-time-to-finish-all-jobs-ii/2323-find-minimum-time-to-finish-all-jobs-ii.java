class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int max = 0;
        for(int i=0; i<workers.length; i++)
        {
            int days = jobs[i]/workers[i];
            if(jobs[i]%workers[i] > 0)
            {
                days++;
            }
            max = Math.max(days, max);
        }
        return max;
    }
}