class Solution {
    public void nextPermutation(int[] nums) {
        int peakIdx = -1;
        for(int i=nums.length-2; i>=0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                peakIdx = i;
                break;
            }
        }
        if(peakIdx == -1)
        {
            Arrays.sort(nums);
            return;
        }
        int nextGreater = nums.length;
        for(int i=nums.length-1; i>peakIdx; i--)
        {
            if(nums[i] > nums[peakIdx])
            {
                if(nextGreater == nums.length || nums[i] < nums[nextGreater])
                {
                    nextGreater = i;
                }
            }
        }
        int temp = nums[nextGreater];
        nums[nextGreater] = nums[peakIdx];
        nums[peakIdx] = temp;
        int end = nums.length-1;
        int start = peakIdx+1;
        while(start < end)
        {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}