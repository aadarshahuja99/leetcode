class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int n = nums.length;
        int currentWindowSum = 0;
        int minWindowLength = nums.length+1;
        while(j < n)
        {
            if(currentWindowSum < target)
            {
                currentWindowSum += nums[j];
                j++;
            }
            else
            {
                int lastIndex = i;
                while(i < j && currentWindowSum >= target)
                {
                    currentWindowSum -= nums[i];
                    lastIndex = i;
                    i++;
                }
                minWindowLength = Math.min(minWindowLength, j-lastIndex);
            }
        }
        if(currentWindowSum >= target)
        {
            int lastIndex = i;
            while(i < j && currentWindowSum >= target)
            {
                currentWindowSum -= nums[i];
                lastIndex = i;
                i++;
            }
            minWindowLength = Math.min(minWindowLength, j-lastIndex);
        }
        return minWindowLength == nums.length+1 ? 0 : minWindowLength;
    }
}