class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int k = 2; k < n; k++)
        {
            int first = 0;
            int second = k-1;
            while(first < second)
            {
                if(nums[first] + nums[second] > nums[k])
                {
                    ans += second - first;
                    second--;
                }
                else
                {
                    first++;
                }
            }
        }
        return ans;
    }
}