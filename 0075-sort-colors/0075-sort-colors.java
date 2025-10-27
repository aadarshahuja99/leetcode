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
                // swap it with low-th guy
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
            {
                // do nothing in this case
                mid++;
            }
            else
            {
                // swap it with high-th guy if nums[mid] = 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}