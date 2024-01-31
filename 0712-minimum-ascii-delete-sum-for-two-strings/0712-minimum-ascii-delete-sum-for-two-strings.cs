public class Solution {
    public int MinimumDeleteSum(string s1, string s2) {
        return GetLCS(s1,s2);
    }
    private int GetLCS(string s1, string s2)
    {
        int[,] dp = new int[s1.Length+1,s2.Length+1];
        int len = LCS(s1,s2,dp);
        int i = s1.Length-1;
        int j = s2.Length-1;
        int sum1 = 0;
        while(i>=0)
        {
            Console.WriteLine((int)s1[i]);
            sum1 += (int)s1[i];
            i--;
        }
        int sum2 = 0;
        while(j>=0)
        {
            sum2 += (int)s2[j];
            j--;
        }
        Console.WriteLine(sum1+" "+sum2);
        return sum1+sum2-2*len;
    }
    private int LCS(string s1, string s2, int[,] dp)
    {
        for(int i=1; i<=s1.Length;i++)
        {
            for(int j=1; j<=s2.Length; j++)
            {
                if(s1[i-1]==s2[j-1])
                {
                    dp[i,j] = (int)s1[i-1]+dp[i-1,j-1]; // storing the ascii sum of the CS
                }
                else
                {
                    dp[i,j] = Math.Max(dp[i-1,j],dp[i,j-1]); // storing the max possible ascii sum CS (longest subsequence is not needed, instead of length, we check for the ascii sum of chars)
                }
            }
        }
        return dp[s1.Length,s2.Length];
    }
    private int GetValue(string s, string lcs)
    {
        int i=0;
        int j=0;
        int ans=0;
        while(j<lcs.Length)
        {
            if(s[i] == lcs[j])
            {
                i++;
                j++;
            }
            else
            {
                // Console.WriteLine($"adding {(int)s[i]} to {ans} for {s[i]}");
                ans += (int)s[i];
                i++;
            }
        }
        while(i<s.Length)
        {
            // Console.WriteLine($"adding {(int)s[i]} to {ans} for {s[i]}");
            ans+=(int)s[i];
            i++;
        }
        return ans;
    }
}