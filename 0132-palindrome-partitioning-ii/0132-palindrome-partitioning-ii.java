class Solution {
    public int minCut(String s) {
        int n = s.length();
        // isPalindrome snippet is re-usable and almost exact answer for longest palindromic substring
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i=0; i<n; i++)
        {
            isPalindrome[i][i] = true;
            if(i < n-1 && s.charAt(i) == s.charAt(i+1))
            {
                isPalindrome[i][i+1] = true;
            }
        }
        for(int length = 3; length <= n; length++)
        {
            for(int start = 0; start <= n-length; start++)
            {
                isPalindrome[start][start+length-1] = isPalindrome[start+1][start+length-2] && s.charAt(start) == s.charAt(start+length-1);
            }
        }
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return getAns(0, s, cache, isPalindrome) - 1;
    }
    private int getAns(int currentIndex, String s, int[] cache, boolean[][] isPalindrome)
    {
        if(currentIndex == s.length())
        {
            return 0;
        }
        if(cache[currentIndex] != -1)
        {
            return cache[currentIndex];
        }
        int ans = s.length() + 1;
        for(int i=currentIndex; i<s.length(); i++)
        {
            if(isPalindrome[currentIndex][i])
            {
                ans = Math.min(ans, 1 + getAns(i+1, s, cache, isPalindrome));
            }
        }
        return cache[currentIndex] = ans;
    }
}