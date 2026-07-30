class Solution {
    int MOD = Integer.MAX_VALUE;
    int base = 29;
    public int longestDecomposition(String s) {
        // String rev = (new StringBuilder(s)).reverse().toString();
        long hashStart = 0l;
        long hashEnd = 0l;
        long hash = 1l;
        int n = s.length();
        int end = n-1;
        int ans = 0;
        int start = 0;
        int lastMatchEnd = -1;
        int lastMatchStart = -1;
        while(start < end)
        {
            int charStart = s.charAt(start) - 'a' + 1;
            int charEnd = s.charAt(end) - 'a' + 1;
            hashStart = (hashStart*base + charStart)%MOD;
            // reverse hash is being computed for the reversed string as the current character is added to the string from the left instead of right
            hashEnd = (hash*charEnd + hashEnd)%MOD;
            hash = (hash*base)%MOD;
            if(hashStart == hashEnd)
            {
                ans += 2;
                hashStart = 0l;
                hashEnd = 0l;
                hash = 1l;
                lastMatchStart = start;
                lastMatchEnd = end;
                System.out.println("found one pair till "+start);
            }
            start++;
            end--;
        }
        if(lastMatchStart == -1)
        {
            return 1;
        }
        return lastMatchEnd - lastMatchStart > 1 ? 1 + ans : ans;
    }
}