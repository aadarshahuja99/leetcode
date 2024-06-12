class Solution {
    public void sortColors(int[] nums) {
        // using the DNF algorithm
        int mid = 0;
        int high = nums.length-1;
        int low = 0;
        while(mid<=high)
        {
            if(nums[mid] == 0)
            {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
            {
                mid++;
            }
            else
            {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}