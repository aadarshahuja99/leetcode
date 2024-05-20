class Solution {
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        int digits = 0;
        int temp = k;
        while(temp > 0)
        {
            digits++;
            temp = temp/10;
        }
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        int ans = getAns(0, k, digits, s, cache);
        return ans;
    }
    private int getAns(int current, int k, int digits, String s, int[] cache)
    {
        if(current == s.length())
        {
            return 1;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        int ways = 0;
        long val = 0;
        for(int i=current; i<Math.min(current + digits, s.length()); i++)
        {
            val = 10*val + (s.charAt(i) - 48)*1L;
            if(val <= (long)k && (i+1 == s.length() || s.charAt(i+1) != '0'))
            {
                ways = (ways%mod + getAns(i+1, k, digits, s, cache)%mod)%mod;
            }
        }
        return cache[current] = ways;
    }
}