class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer,Long> map = new HashMap<>();
        long ans = 0;
        int xor = 0;
        map.put(0, 1L);
        for(int num : nums)
        {
            xor = xor^num;
            if(map.containsKey(xor))
            {
                ans += map.get(xor);
            }
            map.put(xor, map.getOrDefault(xor,0L) + 1L);
        }
        return ans;
    }
}