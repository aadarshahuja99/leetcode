class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<=1000; i++)
        {
            if(check(i, nums))
            {
                return i;
            }
        }
        return -1;
    }
    private boolean check(int guess, int[] nums)
    {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int firstOccurrence = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(nums[mid] >= guess)
            {
                firstOccurrence = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return firstOccurrence == -1 ? false : n - firstOccurrence == guess;
    }
}