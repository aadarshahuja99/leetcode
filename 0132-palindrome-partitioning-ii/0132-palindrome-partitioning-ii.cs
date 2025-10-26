public class Solution {
    public int MinCut(string s) {
        if(s.Length == 1)
        {
            return 0;
        }
        int[] dp = new int[s.Length+1];
        for(int i=0; i<s.Length; i++)
        {
            dp[i] = -1;
        }
        return Helper(dp, 0, s)-1;
    }
    private int Helper(int[] dp, int i, string s)
    {
        if(i == s.Length)
        {
            return 0;
        }
        if(dp[i] != -1)
        {
            return dp[i];
        }
        string current = "";
        int min = s.Length - i;
        for(int j=i; j<s.Length; j++)
        {
            current+=s[j];
            if(isPalindrome(current))
            {
                min = Math.Min(min, 1+Helper(dp, j+1, s));
            }
        }
        dp[i] = min;
        return dp[i];
    }
    private bool isPalindrome(string s)
    {
        int i=0;
        int j=s.Length-1;
        while(i<j)
        {
            if(s[i]!=s[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}