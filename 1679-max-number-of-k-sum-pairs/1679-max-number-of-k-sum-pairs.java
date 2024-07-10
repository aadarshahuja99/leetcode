class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;
        for(int num : nums)
        {
            int complement = k - num;
            visited.add(num);
            if(map.containsKey(complement) && !visited.contains(complement))
            {
                visited.add(complement);
                int min = Math.min(map.get(complement), map.get(num));
                ans += min;
                map.put(num, map.get(num) - min);
            }
            if(map.get(num) > 1 && 2*num == k)
            {
                ans += map.get(num)/2;
                map.put(num, 1);
            }
        }
        return ans;
    }
}