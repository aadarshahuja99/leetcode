class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int runningSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            runningSum += nums[i];
            if(map.containsKey(runningSum - k))
            {
                ans = Math.max(ans, i - map.get(runningSum - k));
            }
            if(!map.containsKey(runningSum))
            {
                map.put(runningSum, i);
            }
        }
        return ans;
    }
}