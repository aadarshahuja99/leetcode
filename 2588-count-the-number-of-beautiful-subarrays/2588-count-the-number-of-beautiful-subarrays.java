class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer,Long> map = new HashMap<>();
        long ans = 0;
        int xor = 0;
        for(int num : nums)
        {
            xor = xor^num;
            if(map.containsKey(xor))
            {
                ans += map.get(xor);
                map.put(xor, map.get(xor)+1L);
            }
            else
            {
                map.put(xor,1L);
            }
            if(xor == 0)
            {
                ans += 1L;
            }
        }
        return ans;
    }
}