class Solution {
    public int strangePrinter(String s) {
        int[][] cache = new int[s.length()][s.length()];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, s.length() - 1, s, cache);
    }
    private int getAns(int start, int end, String s, int[][] cache)
    {
        if(start > end)
        {
            return 0;
        }
        if(cache[start][end] != -1)
        {
            return cache[start][end];
        }
        int i = start;
        while(i <= end && s.charAt(i) == s.charAt(start))
        {
            i++;
        }
        int print = 1 + getAns(i, end, s, cache);
        int it = i;
        while(it <= end)
        {
            if(s.charAt(it) == s.charAt(start))
            {
                print = Math.min(print, getAns(i, it-1, s, cache) + getAns(it, end, s, cache));
            }
            it++;
        }
        return cache[start][end] = print;
    }
}