class Solution {
    public int[] searchRange(int[] nums, int target) {
        int floor = getFloor(target, nums);
        int ceil = getCeil(target, nums);
        if(floor == -1 || ceil == -1 || nums[floor] != target)
        {
            return new int[] { -1, -1 };
        }
        return new int[] { floor, ceil };
    }
    private int getFloor(int x, int[] nums)
    {
        int ans = -1;
        int s = 0;
        int e = nums.length-1;
        while(s <= e)
        {
            int m = s + (e-s)/2;
            if(x <= nums[m])
            {
                ans = m;
                e = m-1;
            }
            else
            {
                s = m+1;
            }
        }
        return ans;
    }
    private int getCeil(int x, int[] nums)
    {
        int ans = -1;
        int s = 0;
        int e = nums.length-1;
        while(s <= e)
        {
            int m = s + (e-s)/2;
            if(x >= nums[m])
            {
                ans = m;
                s = m+1;
            }
            else
            {
                e = m-1;
            }
        }
        return ans;
    }
}