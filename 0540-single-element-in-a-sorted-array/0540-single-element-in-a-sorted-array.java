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
            int count = end-start+1;
            int mid = (start+end)/2;
            if(mid > 0 && mid < nums.length - 1)
            {
                if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid+1])
                {
                    return nums[mid];
                }
                if(nums[mid] == nums[mid - 1])
                {
                    if((mid - start)%2 == 0)
                    {
                        end=mid;
                    }
                    else
                    {
                        start = mid+1;
                    }
                }
                else if(nums[mid] == nums[mid + 1])
                {
                    if((end-mid)%2 == 0)
                    {
                        start = mid;
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