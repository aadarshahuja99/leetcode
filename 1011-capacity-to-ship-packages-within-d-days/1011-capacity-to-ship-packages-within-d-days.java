class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = weights[0];
        int sum = weights[0];
        for(int i=1; i<weights.length; i++)
        {
            sum += weights[i];
            max = Math.max(max,weights[i]);
        }
        int start = max;
        int end = sum;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(check(mid,weights,days))
            {
                end = mid-1;
                ans = mid;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int current, int weights[], int days)
    {
        int idx = 0;
        int count = 0;
        while(idx < weights.length)
        {
            int sum = 0;
            while(idx < weights.length && weights[idx] + sum <= current)
            {
                sum += weights[idx];
                idx++;
            }
            count++;
        }
        return count <= days;
    }
}