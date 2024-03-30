class Solution {
    public long countSubarrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int max = 0;
        for(int num : nums)
        {
            max = Math.max(max, num);
        }
        int countMax = 0;
        long ans = 0;
        while(j < nums.length)
        {
            if(countMax < k)
            {
                if(nums[j] == max)
                {
                    countMax++;
                }
                j++;
            }
            else if(countMax == k)
            {
                int candidateLength = j-i;
                int rightRem = nums.length-candidateLength-i;
                // System.out.println(i+" "+candidateLength+" "+rightRem);
                while(countMax == k)
                {
                    ans = ans + (long)rightRem + 1l;
                    if(nums[i] == max)
                    {
                        countMax--;
                    }
                    i++;
                }
            }
        }
        if(countMax == k)
        {
            int candidateLength = j-i;
            int rightRem = nums.length-candidateLength-i;
            // System.out.println(i+" "+candidateLength+" "+rightRem);
            while(countMax == k)
            {
                ans = ans + (long)rightRem + 1l;
                if(nums[i] == max)
                {
                    countMax--;
                }
                i++;
            }
        }
        return ans;
    }
}