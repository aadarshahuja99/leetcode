class Solution {
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for(int first=0; first<=limit; first++)
        {
            int rem = n-first;
            for(int second=0; second <= Math.min(limit,rem); second++)
            {
                int last = rem-second;
                if(last <= limit)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}