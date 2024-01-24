class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            dp[i][i] = true;
            count++;
            if(i != s.length()-1 && s.charAt(i) == s.charAt(i+1))
            {
                dp[i][i+1] = true;
                count++;
            }
        }
        for(int k=3; k<=s.length(); k++)
        {
            for(int i=0; i<=s.length()-k; i++)
            {
                int j=i+k-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                {
                    count++;
                    dp[i][j] = true;
                }
            }
        }
        return count;
    }
}