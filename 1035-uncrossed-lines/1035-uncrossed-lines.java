class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length+1];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getMaxConnections(0, -1, nums1, nums2, dp);
    }
    private int getMaxConnections(int current1, int lastUsedNums2, int[] nums1, int[] nums2, int[][] dp)
    {
        if(current1 == nums1.length)
        {
            return 0;
        }
        if(dp[current1][lastUsedNums2+1] != -1)
        {
            return dp[current1][lastUsedNums2+1];
        }
        int ans = getMaxConnections(current1 + 1, lastUsedNums2, nums1, nums2, dp);
        for(int i=lastUsedNums2+1; i<nums2.length; i++)
        {
            if(nums2[i] == nums1[current1])
            {
                ans = Math.max(1 + getMaxConnections(current1+1, i, nums1, nums2, dp), ans);
            }
        }
        return dp[current1][lastUsedNums2+1] = ans;
    }
}