class Solution {
    public int removeDuplicates(int[] nums) {
        // k times generic template
        int target = 2;
        int n = nums.length;
        if(n <= 2)
        {
            return n;
        }
        int countOfCurrent = 1;
        int pointer = 1;
        for(int i=1; i<n; i++)
        {
            if(nums[i] == nums[i-1])
            {
                countOfCurrent++;
                if(countOfCurrent <= target)
                {
                    nums[pointer++] = nums[i];
                }
            }
            else
            {
                countOfCurrent = 1;
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}