class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        if(x == 0)
        {
            return 0;
        }
        // treeset based question. Use floor and ceiling methods
        // running treeset.
        // https://leetcode.com/problems/subarray-sum-equals-k/ approach plus treeset
        TreeSet<Integer> set = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        for(int i=x; i<nums.size(); i++)
        {
            if(i-x >= 0)
            {
                set.add(nums.get(i-x));
            }
            Integer floor = set.floor(nums.get(i));
            if(floor != null)
            {
                min = Math.min(min, Math.abs(floor - nums.get(i)));
            }
            Integer ceiling = set.ceiling(nums.get(i));
            if(ceiling != null)
            {
                min = Math.min(Math.abs(ceiling - nums.get(i)), min);
            }
        }
        return min;
    }
}