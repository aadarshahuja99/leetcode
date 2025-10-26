class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
        }
        int ans = 0;
        for(int num : nums)
        {
            if(!set.contains(num-1))
            {
                int current = 1;
                int it = num+1;
                while(set.contains(it))
                {
                    set.remove(it);
                    it++;
                    current++;
                }
                ans = Math.max(ans, current);
            }
        }
        return ans;
    }
}