class Solution {
    HashMap<Integer,List<Integer>> valueMap;
    public Solution(int[] nums) {
        valueMap = new HashMap<Integer,List<Integer>>();
        int idx = 0;
        for(int num : nums)
        {
            if(!valueMap.containsKey(num))
            {
                valueMap.put(num, new ArrayList<>());
            }
            valueMap.get(num).add(idx);
            idx++;
        }
    }
    
    public int pick(int target) {
        Random random = new Random();
        List<Integer> indexes = valueMap.get(target);
        return indexes.get(random.nextInt(indexes.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */