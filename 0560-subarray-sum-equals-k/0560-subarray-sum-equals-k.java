class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int num : nums)
        {
            sum += num;
            if(sumMap.containsKey(sum - k))
            {
                ans += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}