class Solution {
    public int countSubarrays(int[] nums, int k) {
        int diffBeforeK = 0;
        int idx = 0;
        int n = nums.length;
        while(idx < n && nums[idx] != k)
        {
            if(nums[idx] > k)
            {
                diffBeforeK++;
            }
            else if(nums[idx] < k)
            {
                diffBeforeK--;
            }
            idx++;
        }

        if(idx == n)
        {
            return 0;
        }

        HashMap<Integer,Integer> countMap = new HashMap<>();

        // construct the map starting from the 1st occurrence
        int diffPostK = 0;
        for(int i=idx; i<n; i++)
        {
            if(nums[i] < k)
            {
                diffPostK--;
            }
            if(nums[i] > k)
            {
                diffPostK++;
            }
            countMap.put(diffPostK, countMap.getOrDefault(diffPostK, 0) + 1);
        }
        int ans = 0;
        for(int i=0; i<=idx; i++)
        {
            // from ith position, count the number of subarrays that contain k and have a sum of 1 or 0
            if(countMap.containsKey(-diffBeforeK))
            {
                ans += countMap.get(-diffBeforeK);
            }
            if(countMap.containsKey(1-diffBeforeK))
            {
                ans += countMap.get(1-diffBeforeK);
            }
            if(nums[i] > k)
            {
                diffBeforeK--;
            }
            else
            {
                diffBeforeK++;
            }
        }
        return ans;
    }
}