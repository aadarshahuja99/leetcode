class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int ans = 0;
        for(int i=0; i<s.length(); i++)
        {
            ans++;
            isPalindrome[i][i] = true;
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1))
            {
                isPalindrome[i][i+1] = true;
                ans++;
            }
        }
        for(int len = 3; len <= s.length(); len++)
        {
            for(int i=0; i<=s.length() - len; i++)
            {
                isPalindrome[i][i+len-1] = s.charAt(i) == s.charAt(i+len-1) && isPalindrome[i+1][i+len-2];
                if(isPalindrome[i][i+len-1])
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}