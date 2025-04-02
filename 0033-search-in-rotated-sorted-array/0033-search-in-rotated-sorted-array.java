class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int n = nums.length;
        int e = n-1;
        while(s <= e)
        {
            int mid = s + (e - s)/2;
            if(target == nums[mid])
            {
                return mid;
            }
            if(nums[mid] >= nums[s] && nums[mid] > nums[e])
            {
                // mid is in the bigger half
                if(target < nums[mid] && target >= nums[s])
                {
                    e = mid - 1;
                }
                else
                {
                    // search in unsorted half
                    s = mid + 1;
                }
            }
            else if (nums[mid] <= nums[s] && nums[mid] < nums[e])
            {
                // right half is sorted
                if(nums[mid] < target && target <= nums[e])
                {
                    // search in the sorted half
                    s = mid + 1;
                }
                else
                {
                    // search in the unsorted half
                    e = mid - 1;
                }
            }
            else
            {
                // s, mid, e are all sorted
                if(target < nums[mid])
                {
                    e = mid - 1;
                }
                else
                {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}