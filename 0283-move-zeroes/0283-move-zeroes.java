class Solution {
    public void moveZeroes(int[] nums) {
        int firstZero = -1;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == 0)
            {
                firstZero = i;
                break;
            }
        }
        if(firstZero == -1)
        {
            return;
        }
        for(int i=firstZero+1; i<n; i++)
        {
            if(nums[i] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[firstZero];
                nums[firstZero] = temp;
                firstZero++;
            }
        }
    }
}