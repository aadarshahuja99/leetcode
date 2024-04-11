class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int[] setBits = new int[32];
        int start=0;
        int end=0;
        int violatingBits = 0;
        int ans = 0;
        while(end < n)
        {
            if(violatingBits == 0)
            {
                violatingBits = setBitsAndCheckForViolation(nums[end], setBits);
                // for(int i=0; i<32; i++)
                // {
                //     System.out.print(setBits[i]+" ");
                // }
                // System.out.println();
                end++;
            }
            else
            {
                ans = Math.max(ans, end-start-1);
                // System.out.println(end+" "+start);
                // remove start until violatingBits becomes zero
                while(start < n && violatingBits > 0)
                {
                    violatingBits = removeBits(nums[start], setBits, violatingBits);
                    start++;
                }
                // for(int i=0; i<32; i++)
                // {
                //     System.out.print(setBits[i]+" ");
                // }
                // System.out.println();
                // System.out.println("after fixing: "+start+" "+end);
            }
        }
        if(violatingBits > 0)
        {
            ans = Math.max(ans, end-start-1);
        }
        else
        {
            ans = Math.max(end-start, ans);
        }
        return ans;
    }
    private int setBitsAndCheckForViolation(int number, int[] setBits)
    {
        int idx = 0;
        int violatingBits = 0;
        int temp = number;
        while(temp > 0)
        {
            if((number&(1<<idx)) > 0)
            {
                setBits[idx]++;
                if(setBits[idx] > 1)
                {
                    violatingBits++;
                }
            }
            temp = temp>>1;
            idx++;
        }
        return violatingBits;
    }
    private int removeBits(int number, int[] setBits, int violatingBits)
    {
        int idx = 0;
        int temp = number;
        while(temp > 0)
        {
            if((number&(1<<idx)) > 0)
            {
                setBits[idx]--;
                if(setBits[idx] == 1)
                {
                    violatingBits--;
                }
            }
            temp = temp>>1;
            idx++;
        }
        return violatingBits;
    }
}