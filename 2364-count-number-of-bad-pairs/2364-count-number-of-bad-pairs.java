class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        // map.put(nums[0], 1);
        long ans = 0;
        for(int i=0; i<n; i++)
        {
            ans += i - map.getOrDefault(nums[i] - i, 0);
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }
        return ans;
    }
}