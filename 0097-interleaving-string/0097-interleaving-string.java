class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
        {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return checkForInterleaving(s1.length(), s2.length(), s1, s2, s3, dp);
    }
    private boolean checkForInterleaving(int index1, int index2, String s1, String s2, String s3, Boolean[][] dp)
    {
        if(index1 == 0 && index2 == 0)
        {
            return true;
        }
        if(index1 == 0)
        {
            while(index2 > 0)
            {
                if(s3.charAt(index2-1) != s2.charAt(index2-1))
                {
                    return false;
                }
                index2--;
            }
            return true;
        }
        if(index2 == 0)
        {
            while(index1 > 0)
            {
                if(s3.charAt(index1-1) != s1.charAt(index1-1))
                {
                    return false;
                }
                index1--;
            }
            return true;            
        }
        if(dp[index1][index2] != null)
        {
            return dp[index1][index2];
        }
        char currentTargetStringCharacter = s3.charAt(index2+index1-1);
        if(currentTargetStringCharacter != s2.charAt(index2-1) && currentTargetStringCharacter != s1.charAt(index1-1))
        {
            return dp[index1][index2] = false;
        }
        if(currentTargetStringCharacter == s1.charAt(index1-1) && currentTargetStringCharacter == s2.charAt(index2-1))
        {
            return dp[index1][index2] = checkForInterleaving(index1, index2-1, s1, s2, s3, dp) || checkForInterleaving(index1-1, index2, s1, s2, s3, dp);
        }
        if(currentTargetStringCharacter == s2.charAt(index2-1))
        {
            return dp[index1][index2] = checkForInterleaving(index1, index2-1, s1, s2, s3, dp);
        }
        return dp[index1][index2] = checkForInterleaving(index1-1, index2, s1, s2, s3, dp);
    }
}