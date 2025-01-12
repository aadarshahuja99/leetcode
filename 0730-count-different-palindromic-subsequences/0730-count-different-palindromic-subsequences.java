class Solution {
    int MOD = 1_000_000_007;
    public int countPalindromicSubsequences(String s) {
        int[][] cache = new int[s.length()][s.length()];
        for(int[] r : cache)
        {
            Arrays.fill(r, -1);
        }
        return getAns(0, s.length()-1, s, cache);
    }
    private int getAns(int st, int end, String s, int[][] cache)
    {
        if(st == end)
        {
            return 1;
        }
        if(st > end)
        {
            return 0;
        }
        if(cache[st][end] != -1)
        {
            return cache[st][end];
        }
        if(s.charAt(st) == s.charAt(end))
        {
            int ans = (int)(2l*getAns(st+1, end-1, s, cache))%MOD;
            int i = st+1;
            int j = end-1;
            while(i <= j && s.charAt(i) != s.charAt(st))
            {
                i++;
            }
            while(i <= j && s.charAt(j) != s.charAt(st))
            {
                j--;
            }
            if(i > j)
            {
                return cache[st][end] = (ans+2)%MOD;
            }
            else if(i == j)
            {
                return cache[st][end] = (ans+1)%MOD;
            }
            else
            {
                return cache[st][end] = ((ans - getAns(i+1, j-1, s, cache))%MOD + MOD)%MOD;
            }
        }
        else
        {
            return cache[st][end] = (((getAns(st+1, end, s, cache)%MOD + getAns(st, end-1, s, cache)%MOD)%MOD - getAns(st+1, end-1, s, cache)%MOD)%MOD + MOD)%MOD;
        }
    }
}