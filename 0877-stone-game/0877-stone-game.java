class Solution {
    public boolean stoneGame(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--)
        {
            for(int j=0; j<n; j++)
            {
                if(j < i)
                {
                    continue;
                }
                if(i == j)
                {
                    cache[i][j] = -1*nums[i];
                    continue;
                }
                int moves = n - 1 - j + i;
                if(moves%2 == 0)
                {
                    cache[i][j] = Math.max(nums[i] + cache[i+1][j], nums[j] + cache[i][j-1]);
                }
                else
                {
                    cache[i][j] = Math.min(-1*nums[i] + cache[i+1][j], -1*nums[j] + cache[i][j-1]);
                }
            }
        }
        return cache[0][n-1] > 0;
    }
}