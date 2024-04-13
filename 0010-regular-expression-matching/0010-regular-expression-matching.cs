public class Solution {
    public bool IsMatch(string s, string p) {
        int[,] dp = new int[s.Length+1,p.Length+1];
        return Helper(s,p,s.Length,p.Length,dp);
    }
        private bool Helper(string s, string p, int i, int j, int[,] dp)
    {
        if(i==0 && j==0)
        {
            return true;
        }
        if(j==0)
        {
            return false;
        }
        if(i==0)
        {
            while(j > 0)
            {
                if(p[j-1] == '*')
                {
                    j-=2;
                    continue;
                }
                break;
            }
            return j==0;
        }
        if(dp[i,j] != 0)
        {
            return dp[i,j] == 2;
        }
        if(s[i-1] == p[j-1] || p[j-1] == '.')
        {
            bool temp = Helper(s,p,i-1,j-1,dp);
            dp[i,j] = temp ? 2 : 1;
            return temp;
        }
        else
        {
            if(p[j-1] == '*')
            {
                bool ans = false;
                int ind = i-1;
                if(p[j-2] == s[i-1] || p[j-2] == '.')
                {
                    ans = Helper(s,p,ind,j,dp) || Helper(s,p,i,j-1,dp) || Helper(s,p,i,j-2,dp);
                }
                else
                {
                    ans = Helper(s,p,i,j-1,dp) || Helper(s,p,i,j-2,dp);
                }
                dp[i,j] = ans ? 2 : 1;
                return ans;
            }
            else
            {
                dp[i,j] = 1;
                return false;
            }
        }
    }
}