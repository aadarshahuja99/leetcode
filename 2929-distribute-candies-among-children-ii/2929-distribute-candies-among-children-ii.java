class Solution {
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        for(int i=0; i<=limit; i++)
        {
            int remaining = n-i;
            if(remaining > 2*limit || remaining < 0)
            {
                continue;
            }
            int min = Math.max(remaining-limit, 0);
            int max = Math.min(limit, remaining);
            // System.out.println(i+" "+max+" "+min);
            ans += (max - min + 1);
        }
        return ans;
    }
}