class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=1; i<n-1; i+=2)
        {
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
    }
}