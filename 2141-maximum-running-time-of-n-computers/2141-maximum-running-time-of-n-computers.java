class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // BS. Not very intuitive
        long start = 0;
        long end = 0;
        long sum = 0;
        for(int b : batteries)
        {
            sum += b;
        }
        end = sum/n;
        long ans = 0;
        while(start <= end)
        {
            long mid = start + (end - start)/2;
            if(check(mid, batteries, n))
            {
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
    private boolean check(long guess, int[] batteries, int n)
    {
        long total = 0;
        for(int num : batteries)
        {
            total += Math.min(guess, num);
        }
        return total >= 1L*guess*n;
    }
}