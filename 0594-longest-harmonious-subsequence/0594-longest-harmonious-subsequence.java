class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
            int count = map.get(num);
            int lower = map.getOrDefault(num-1, 0);
            int higher = map.getOrDefault(num+1, 0);
            if(lower == 0 && higher == 0)
            {
                continue;
            }
            ans = Math.max(ans, count + Math.max(lower, higher));
        }
        return ans;
    }
}