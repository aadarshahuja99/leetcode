class Solution {
    int ans = 0;
    int modulo = 1000000007;
    HashMap<String,Integer> dp = new HashMap<>();
    final int default_min = 2*100000001;
    public int sumOfPowers(int[] nums, int k) {
        // sorting will not impact the answer. BECAUSE, subsets are the same as subsequences, but subsequences are not the same as subsets.
        // Thus, we can safely convert our subsequences into subsets. But the reverse conversion will distort the answer. Subseq questions are therefore subset questions
        Arrays.sort(nums);
        return getAns(0,-1,k,default_min,nums);
    }
    private int getAns(int currentIndex, int lastIndex, int k, int min_difference, int[] nums)
    {
        if(currentIndex == nums.length)
        {
            if(k == 0)
            {
                return min_difference;
            }
            return 0;
        }
        if(k == 0)
        {
            return min_difference;
        }
        String key = currentIndex + "_" + lastIndex + "_" + k + "_" + min_difference;
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        int notTake = getAns(currentIndex + 1, lastIndex, k, min_difference, nums);
        if(lastIndex == -1)
        {
            int take = getAns(currentIndex + 1, currentIndex, k-1, min_difference, nums);
            int ret1 = (take%modulo + notTake%modulo)%modulo;
            dp.put(key, ret1);
            return ret1; 
        }
        int take2 = getAns(currentIndex + 1, currentIndex, k-1, Math.min(min_difference, Math.abs(nums[currentIndex] - nums[lastIndex])), nums);
        int ret2 = (take2%modulo + notTake%modulo)%modulo;
        dp.put(key, ret2);
        return ret2;
    }
}