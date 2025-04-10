class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        int ans = getAns(0, s, cache);
        if(ans == Integer.MIN_VALUE)
        {
            return 0;
        }
        return ans;
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
        if(s.charAt(current) == '0')
        {
            return cache[current] = Integer.MIN_VALUE;
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
            int val = getAns(i+1, s, cache);
            // System.out.println("for start = "+current+" and num = "+num+" val = "+val);
            if(val == Integer.MIN_VALUE)
            {
                continue;
            }
            ans += val;
        }
        return cache[current] = ans;
    }
}