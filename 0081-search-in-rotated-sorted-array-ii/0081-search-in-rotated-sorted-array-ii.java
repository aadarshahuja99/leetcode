class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int n = nums.length;
        int e = n-1;
        System.out.println("len: "+n);
        while(s <= e)
        {
            int mid = s + (e - s)/2;
            if(target == nums[mid])
            {
                return true;
            }
            if(nums[mid] == nums[s] && nums[mid] == nums[e])
            {
                s++;
                e--;
                continue;
            }
            if(nums[mid] >= nums[s] && nums[mid] >= nums[e])
            {
                // left half is sorted
                if(target <= nums[mid] && target >= nums[s])
                {
                    // search in the sorted half
                    e = mid - 1;
                }
                else
                {
                    // search in the unsorted half
                    s = mid + 1;
                }
            }
            else if (nums[mid] <= nums[s] && nums[mid] <= nums[e])
            {
                // right half is sorted
                if(nums[mid] <= target && target <= nums[e])
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
        return false;
    }
}