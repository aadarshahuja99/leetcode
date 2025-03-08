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
        int len = 3;
        for(int k=len; k<=n; k++)
        {
            for(int start=0; start<=n-k; start++)
            {
                if(s.charAt(start) == s.charAt(start+k-1) && isPalindrome[start+1][start+k-2])
                {
                    ansStart = start;
                    max = k;
                    isPalindrome[start][start+k-1] = true;
                }
            }
        }
        System.out.println(max+" "+ansStart);
        return s.substring(ansStart, ansStart+max);
    }
}