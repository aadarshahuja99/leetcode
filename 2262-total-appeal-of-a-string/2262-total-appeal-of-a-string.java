class Solution {
    public long appealSum(String s) {
        long[] dp = new long[s.length()];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last,-1);
        long ans = dp[0];
        last[s.charAt(0)-97] = 0;
        for(int i=1; i<s.length(); i++)
        {
            int alphabetIndex = s.charAt(i) - 97;
            if(last[alphabetIndex] == -1)
            {
                dp[i] = dp[i-1] + i+1;
            }
            else
            {
                dp[i] = dp[i-1] + i-last[alphabetIndex];
            }
            last[alphabetIndex] = i;
            ans += dp[i];
        }
        return ans;
    }
}