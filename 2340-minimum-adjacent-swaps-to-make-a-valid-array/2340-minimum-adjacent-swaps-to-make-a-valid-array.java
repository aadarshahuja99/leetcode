class Solution {
    public int minimumSwaps(int[] nums) {
        int smallest = -1;
        int largest = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] >= max)
            {
                max = nums[i];
                largest = i;
            }
            if(nums[i] < min)
            {
                min = nums[i];
                smallest = i;
            }
        }
        if(smallest == 0 && largest == nums.length - 1 || min == max)
        {
            return 0;
        }
        // System.out.println(smallest+" "+largest);
        if(smallest > largest)
        {
            return smallest + (nums.length - 1 - largest) - 1;
        }
        return smallest + (nums.length - 1 - largest);
    }
}