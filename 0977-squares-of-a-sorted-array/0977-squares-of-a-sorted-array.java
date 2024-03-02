class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            ans[i] = Math.abs(nums[i]);
        }
        Arrays.sort(ans);
        for(int i=0; i<nums.length; i++)
        {
            ans[i] = ans[i]*ans[i];
        }
        return ans;
    }
}