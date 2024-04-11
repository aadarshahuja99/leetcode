class Solution {
    public int minOperations(int[] nums, int x) {
        // the problem can be reduced to finding the longest length subarray of sum = sum(nums) - 5
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += nums[i];
        }
        // first occurrence of any sum in nums
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        int target = sum - x;
        int ans = 0;
        int current = 0;
        if(target == 0)
        {
            return n;
        }
        for(int i=0; i<n; i++)
        {
            current += nums[i];
            if(current == target)
            {
                ans = Math.max(ans, i+1);
            }
            else if(sumMap.containsKey(current- target))
            {
                ans = Math.max(ans, i - sumMap.get(current - target));
            }
            if(!sumMap.containsKey(current))
            {
                sumMap.put(current, i);
            }
        }
        if(ans == 0)
        {
            return -1;
        }
        return n - ans;
    }
}