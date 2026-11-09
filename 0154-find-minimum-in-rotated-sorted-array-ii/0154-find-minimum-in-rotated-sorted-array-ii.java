class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[start] == nums[mid] && nums[mid] == nums[end])
            {
                int current = nums[mid];
                if(current < min)
                {
                    min = current;
                }
                start++;
                end--;
                continue;
            }
            // right half is unsorted
            if(nums[mid] > nums[end])
            {
                // check if the min of the sorted half is a potential answer
                int current = nums[start];
                if(current < min)
                {
                    min = current;
                }
                // move in the unsorted half
                start = mid+1;
            }
            else
            {
                int current = nums[mid];
                if(current < min)
                {
                    min = current;
                }
                end = mid-1;
            }
        }
        return min;
    }
}