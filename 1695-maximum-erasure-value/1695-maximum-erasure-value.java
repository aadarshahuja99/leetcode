class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        int j=0;
        int n = nums.length;
        int currentSum = 0;
        int ans = 0;
        boolean isValid = true;
        while(j<n)
        {
            if(isValid)
            {
                if(set.contains(nums[j]))
                {
                    isValid = false;
                    continue;
                }
                currentSum += nums[j];
                set.add(nums[j]);
                j++;
            }
            else
            {
                ans = Math.max(currentSum, ans);
                int target = nums[j];
                while(nums[i] != target)
                {
                    set.remove(nums[i]);
                    currentSum -= nums[i];
                    i++;
                }
                set.remove(nums[i]);
                currentSum -= nums[i];
                isValid = true;
                i++;
            }
        }
        if(isValid)
        {
            ans = Math.max(ans, currentSum);
        }
        return ans;
    }
}