class Solution {
    public int minMoves2(int[] nums) {
        int median = getMedian(nums);
        int ans = 0;
        for(int num : nums)
        {
            ans += Math.abs(num - median);
        }
        return ans;
    }
    // using quick select algo to find median
    private int getMedian(int[] nums)
    {
        Random r = new Random();
        int s = 0;
        int e = nums.length-1;
        int target = nums.length/2;
        while(s <= e)
        {
            int idx = s + r.nextInt(e - s + 1);
            int pivot = quickSelect(idx, s, e, nums);
            if(pivot == target)
            {
                return nums[pivot];
            }
            else if(pivot > target)
            {
                e = pivot - 1;
            }
            else
            {
                s = pivot + 1;
            }
        }
        return -1;
    }
    private int quickSelect(int idx, int l, int r, int[] nums)
    {
        swap(r, idx, nums);
        int start = l;
        for(int i = l; i<r; i++)
        {
            if(nums[i] < nums[r])
            {
                swap(start, i, nums);
                start++;
            }
        }
        swap(start, r, nums);
        return start;
    }
    private void swap(int i1, int i2, int[] nums)
    {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}