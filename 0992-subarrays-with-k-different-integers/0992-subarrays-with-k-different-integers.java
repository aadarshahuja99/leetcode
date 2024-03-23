class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums.length == 1)
        {
            return nums.length;
        }
        int i=0;
        int j=1;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int distinctCount = 1;
        map.put(nums[0],1);
        while(j<nums.length)
        {
            if(distinctCount < k)
            {
                if(map.containsKey(nums[j]))
                {
                    map.put(nums[j], map.get(nums[j]) + 1);
                }
                else
                {
                    map.put(nums[j], 1);
                    distinctCount++;
                }
                j++;
            }
            else if(distinctCount == k)
            {
                int it = j;
                while(it < nums.length && map.containsKey(nums[it]))
                {
                    it++;
                }
                int options = it-j;
                while(i <= j && distinctCount == k)
                {
                    ans += options+1;
                    map.put(nums[i], map.get(nums[i])-1);
                    if(map.get(nums[i]) == 0)
                    {
                        map.remove(nums[i]);
                        distinctCount--;
                    }
                    i++;
                }
            }
        }
        if(distinctCount == k)
        {
            int it = j;
            while(it < nums.length && map.containsKey(nums[it]))
            {
                it++;
            }
            int options = it-j;
            while(i <= j && distinctCount == k)
            {
                ans += options+1;
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0)
                {
                    map.remove(nums[i]);
                    distinctCount--;
                }
                i++;
            }
        }
        return ans;
    }
}