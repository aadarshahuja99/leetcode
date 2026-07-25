class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
        {
            return nums[0];
        }
        int end = nums.length - 1;
        int start = 0;
        while(start <= end)
        {
            int mid = (start+end)/2;
            if(mid > 0 && mid < nums.length - 1)
            {
                if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid+1])
                {
                    return nums[mid];
                }
                if(nums[mid] == nums[mid - 1])
                {
                    if((mid)%2 == 0)
                    {
                        end=mid - 1;
                    }
                    else
                    {
                        start = mid + 1;
                    }
                }
                else if(nums[mid] == nums[mid + 1])
                {
                    if((mid)%2 == 0)
                    {
                        start = mid + 1;
                    }
                    else
                    {
                        end = mid - 1;
                    }
                }
            }
            else
            {
                return nums[mid];
            }
        }
        return -1;
    }
}