class Solution {
    public long numberOfWays(String s) {
        int zeroes = 0;
        int ones = 0;
        long oneZeroes = 0;
        long zeroOnes = 0;
        long ans = 0;
        for(char ch : s.toCharArray())
        {
            int element = ch - '0';
            if(element == 0)
            {
                zeroes++;
                oneZeroes += ones;
                ans += zeroOnes;
            }
            else
            {
                ones++;
                zeroOnes += zeroes;
                ans += oneZeroes;
            }
        }
        return ans;
    }
    // public long numberOfWays(String s) {
    //     long[][][] cache = new long[s.length()][4][3];
    //     for(long[][] nested : cache)
    //     {
    //         for(long[] row : nested)
    //         {
    //             Arrays.fill(row, -1);
    //         }
    //     }
    //     return getAns(0, 0, 2, s, cache);
    // }
    // private long getAns(int current, int selected, int last, String s, long[][][] cache)
    // {
    //     if(current == s.length())
    //     {
    //         return selected == 3 ? 1 : 0;
    //     }
    //     if(selected == 3)
    //     {
    //         return 1;
    //     }
    //     if(cache[current][selected][last] != -1)
    //     {
    //         return cache[current][selected][last];
    //     }
    //     int element = s.charAt(current) - '0';
    //     long notTake = getAns(current+1, selected, last, s, cache);
    //     if(element != last)
    //     {
    //         long take = getAns(current+1, selected+1, element, s, cache);
    //         return cache[current][selected][last] = take + notTake;
    //     }
    //     return cache[current][selected][last] = notTake;
    // }
}