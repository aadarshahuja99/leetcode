class Solution {
    int MOD = Integer.MAX_VALUE;
    int base = 29;
    public String shortestPalindrome(String s) {
        if(s.equals(""))
        {
            return s;
        }
        String rev = new StringBuilder(s).reverse().toString();
        long hashStart = 0l;
        long hashEnd = 0l;
        long hash = 1l;
        int n = s.length();
        int end = n-1;
        int ans = 0;
        int start = 0;
        while(start < n)
        {
            int charStart = s.charAt(start) - 'a' + 1;
            int charEnd = rev.charAt(end) - 'a' + 1;
            hashStart = (hashStart*base + charStart)%MOD;
            hashEnd = (hash*charEnd + hashEnd)%MOD;
            hash = (hash*base)%MOD;
            if(hashStart == hashEnd)
            {
                ans = start;
            }
            start++;
            end--;
        }
        if(ans == n-1)
        {
            return s;
        }
        return (new StringBuilder(s.substring(ans+1)).reverse().append(s).toString());
    }
}