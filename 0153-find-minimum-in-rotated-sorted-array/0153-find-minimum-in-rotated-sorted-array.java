class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            // move towards the unsorted half (opposite of what we were doing in Search in rotated sorted array)
            if(nums[mid] > nums[end])
            {
                // nums[start] is the minimum element of the sorted half, when we eliminate the sorted half, we compute ans by using its guaranteed minimum element
                int current = nums[start];
                if(current < min)
                {
                    min = current;
                }
                start = mid+1;
            }
            else
            {
                // nums[mid] is the minimum element of the sorted half, when we eliminate the sorted half, we compute ans by using its guaranteed minimum element
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