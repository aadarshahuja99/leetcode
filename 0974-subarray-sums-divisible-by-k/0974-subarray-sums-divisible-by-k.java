class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(0, 1);
        for(int num : nums)
        { 
            sum += num;
            // Reminders can not be negative in Maths but Java does not follow this, (-3)%5 in java = -3
            // but the correct answer in maths is 2 for it
            // (sum%k + k)%k will ensure correct reminders are found and not java based reminders in case of negative numbers 
            if(map.containsKey((sum%k + k)%k))
            {
                ans += map.get((sum%k + k)%k);
            }
            map.put((sum%k + k)%k, map.getOrDefault((sum%k + k)%k, 0) + 1);
        }
        return ans;
    }
}