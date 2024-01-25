class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int p2=0;
        int p3=0;
        int p5=0;
        // intuition: the smallest number that is eligible for multiplication with 2 is the next candidate from 2's end. The same should be done to calculate the candidates from 3's and 5's ends.
        for(int i=1;i<n;i++)
        {
            dp[i] = Math.min(Math.min(2*dp[p2],3*dp[p3]), 5*dp[p5]);
            if(dp[i] == 2*dp[p2])
            {
                p2++;
            }
            if(dp[i] == 3*dp[p3])
            {
                p3++;
            }
            if(dp[i] == 5*dp[p5])
            {
                p5++;
            }
        }
        return dp[n-1];
    }
}