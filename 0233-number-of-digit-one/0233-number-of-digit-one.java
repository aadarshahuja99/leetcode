class Solution {
    public int countDigitOne(int n) {
        int digits = 0;
        List<Integer> list = new ArrayList<>();
        while(n > 0)
        {
            list.add(n%10);
            n = n/10;
        }
        Collections.reverse(list);
        digits = list.size();
        int[][][] dp = new int[digits][2][digits+1];
        for(int[][] nr : dp)
        {
            for(int[] row : nr)
            {
                Arrays.fill(row, -1);
            }
        }
        return getAns(0, 1, 0, list, dp);
    }
    private int getAns(int current, int isRestricted, int count, List<Integer> list, int[][][] dp)
    {
        if(current == list.size())
        {
            return count;
        }
        if(dp[current][isRestricted][count] != -1)
        {
            return dp[current][isRestricted][count];
        }
        int limit = isRestricted == 1 ? list.get(current) : 9;
        int ans = 0;
        // System.out.println(limit+" for "+current+","+isRestricted);
        for(int i=0; i<=limit; i++)
        {
            if(i == 1)
            {
                ans += getAns(current+1, i == limit && isRestricted == 1 ? 1 : 0, count+1, list, dp);
            }
            else
            {
                ans += getAns(current+1, i == limit && isRestricted == 1 ? 1 : 0, count, list, dp);
            }
        }
        return dp[current][isRestricted][count] = ans;
    }
}