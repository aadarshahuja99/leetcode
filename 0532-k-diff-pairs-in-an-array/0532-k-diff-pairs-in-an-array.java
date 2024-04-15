class Solution {
    public int findPairs(int[] nums, int k) {
        // SC and TC O(N): using hashmap
        // SC can be reduced to O(1) using 2 pointers. Not very intuitive though
        
        // 1: using hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums)
        {
            if(map.containsKey(num))
            {
                if(k == 0 && map.get(num) == 1)
                {
                    ans += 1;
                }
                map.put(num, map.get(num)+1);
            }
            else
            {
                if(map.containsKey(num-k))
                {
                    ans += 1;
                }
                if(map.containsKey(num+k))
                {
                    ans += 1;
                }
                map.put(num, 1);
            }
        }
        return ans;
    }
}