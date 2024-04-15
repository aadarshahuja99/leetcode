class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        int[] max = new int[1];
        findLongestCommonSubarrayLength(0,0,nums1,nums2,max,dp);
        return max[0];
    }
    private int findLongestCommonSubarrayLength(int current1, int current2, int[] nums1, int[] nums2, int[] max, int[][] dp)
    {
        if(current1 == nums1.length || current2 == nums2.length)
        {
            return 0;
        }
        if(dp[current1][current2] != -1)
        {
            return dp[current1][current2];
        }
        int maxStartingFromHere = 0;
        if(nums1[current1] == nums2[current2])
        {
            maxStartingFromHere = 1 + findLongestCommonSubarrayLength(current1+1, current2+1, nums1, nums2, max, dp);
        }
        findLongestCommonSubarrayLength(current1+1, current2, nums1, nums2, max, dp);
        findLongestCommonSubarrayLength(current1, current2+1, nums1, nums2, max, dp);
        max[0] = Math.max(max[0], maxStartingFromHere);
        return dp[current1][current2] = maxStartingFromHere;
    }
}