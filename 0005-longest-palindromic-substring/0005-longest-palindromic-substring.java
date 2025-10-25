class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int max = 1;
        int ansStart = 0;
        for(int i=0; i<n; i++)
        {
            isPalindrome[i][i] = true;
            if(i < n-1 && s.charAt(i+1) == s.charAt(i))
            {
                ansStart = i;
                max = 2;
                isPalindrome[i][i+1] = true;
            }
        }
        for(int length=3; length<=n; length++)
        {
            for(int start=0; start<=n-length; start++)
            {
                if(s.charAt(start) == s.charAt(start+length-1) && isPalindrome[start+1][start+length-2])
                {
                    ansStart = start;
                    max = length;
                    isPalindrome[start][start+length-1] = true;
                }
            }
        }
        return s.substring(ansStart, ansStart+max);
    }
}