class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i=0;
        int j=0;
        int n = nums.length;
        long[] pre = new long[n];
        pre[0] = (long)nums[0];
        for(int it=1; it<n; it++)
        {
            pre[it] = pre[it-1] + (long)nums[it];
        }
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int numberOfRepeatingElements = 0;
        long ans = 0;
        while(j < n)
        {
            if(j-i < k)
            {
                countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
                if(countMap.get(nums[j]) == 2)
                {
                    numberOfRepeatingElements++;
                }
                j++;
            }
            else if(j-i == k)
            {
                if(numberOfRepeatingElements == 0)
                {
                    long currentSum = pre[j-1] - pre[i] + nums[i];
                    ans = Math.max(currentSum, ans);
                }
                countMap.put(nums[i], countMap.get(nums[i]) - 1);
                if(countMap.get(nums[i]) == 1)
                {
                    numberOfRepeatingElements--;
                }
                i++;
            }
        }
        if(numberOfRepeatingElements == 0)
        {
            long currentSum = pre[j-1] - pre[i] + nums[i];
            ans = Math.max(currentSum, ans);
        }
        return ans;
    }
}