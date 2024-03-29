class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if(nums.length == 1)
        {
            return 1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int violatingElement = -1;
        int ans = 0;
        while(j < nums.length)
        {
            if(violatingElement == -1)
            {
                map.put(nums[j],map.getOrDefault(nums[j], 0) + 1);
                if(map.get(nums[j]) > k)
                {
                    violatingElement = nums[j];
                }
                j++;
            }
            else
            {
                int candidate = j-i-1;
                ans = Math.max(ans,candidate);
                while(violatingElement != -1)
                {
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if(nums[i] == violatingElement)
                    {
                        violatingElement = -1;
                    }
                    i++;
                }
            }
        }
        if(violatingElement == -1)
        {
            ans = Math.max(ans,j-i);
        }
        else
        {
            ans = Math.max(ans,j-i-1);
        }
        return ans;
    }
}