class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        int currentCount = 0;
        HashMap<Integer,Integer> counts = new HashMap<>();
        while(right < n)
        {
            currentCount += counts.getOrDefault(nums[right], 0);
            counts.put(nums[right], counts.getOrDefault(nums[right], 0) + 1);
            right++;
            if(currentCount >= k)
            {
                // ans += 1l*(n-right+1);
                int start = left;
                while(currentCount >= k)
                {
                    currentCount -= counts.get(nums[left]) > 1 ? counts.get(nums[left]) - 1 : 0;
                    counts.put(nums[left], counts.get(nums[left]) - 1);
                    left++;
                }
                int leftSegmentLength = left - start - 1;
                ans += 1l*(n - right + 1)*(leftSegmentLength + 1);
            }
        }
        return ans;
    }
}