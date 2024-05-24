class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // each element 'num' of the array can be assigned a range: num-k to num+k.
        // We have n intervals now, we have to find the largest intersection of these n intervals. i.e a value from min nums[i] - k to max nums[i] + k
        // DP can not be applied to problems where we are manipulating the elements of the initial array
        int[] hash = new int[3*100000+2];
        for(int num : nums)
        {
            hash[num-k+100000]++;
            hash[num+k+100000+1]--;
        }
        int sum = 0;
        int ans = 0;
        for(int num : hash)
        {
            sum += num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}