class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
        {
            return 0;
        }
        int n = s.length();
        int[] cache = new int[n+1];
        cache[n] = 1;
        for(int i=n-1; i>=0; i--)
        {
            int num = 0;
            int current = 0;
            for(int p = i; p<n; p++)
            {
                num = num*10 + (s.charAt(p) - '0');
                if(num > 26)
                {
                    break;
                }
                if(p+1 < n && s.charAt(p+1) == '0')
                {
                    continue;
                }
                current += cache[p+1];
            }
            cache[i] = current;
        }
        // int ans = getAns(0, s, cache);
        return cache[0];
    }
    private int getAns(int current, String s, int[] cache)
    {
        if(current == s.length())
        {
            return 1;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        int num = 0;
        int ans = 0;
        for(int i=current; i<Math.min(current+2, s.length()); i++)
        {
            num = num*10 + (s.charAt(i) - '0');
            if(num > 26)
            {
                break;
            }
            if(i+1 < s.length() && s.charAt(i+1) == 0)
            {
                continue;
            }
            int val = getAns(i+1, s, cache);
            ans += val;
        }
        return cache[current] = ans;
    }
}