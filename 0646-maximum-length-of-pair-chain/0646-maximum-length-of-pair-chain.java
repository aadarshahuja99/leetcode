class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            }
        });
        int[] dp = new int[pairs.length];
        return getAns(0,pairs,dp);
    }
    private int getAns(int current, int[][] pairs, int[] dp)
    {
        if(current == pairs.length)
        {
            return 1;
        }
        if(dp[current] != 0)
        {
            return dp[current];
        }
        int notTake = getAns(current+1, pairs, dp);
        int end = pairs[current][1];
        for(int i=current+1; i<pairs.length; i++)
        {
            if(pairs[i][0] > end)
            {
                // System.out.println("next for "+pairs[current][0]+","+pairs[current][1]+" = "+pairs[i][0]+","+pairs[i][1]);
                int take = 1 + getAns(i, pairs, dp);
                return dp[current] = Math.max(take, notTake);
            }
        }
        return dp[current] = notTake;
    }
}