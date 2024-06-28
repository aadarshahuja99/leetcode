class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = 0;
        int end = n-1;
        var ans = Double.MAX_VALUE;
        while(start < end)
        {
            var current = (double)(nums[start] + nums[end])/2.0;
            if(current < ans)
            {
                ans = current;
            }
            start++;
            end--;
        }
        return ans;
    }
}