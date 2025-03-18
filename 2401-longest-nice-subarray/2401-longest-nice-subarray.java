class Solution {
    public int longestNiceSubarray(int[] nums) {
        int[] bitMap = new int[32];
        int n = nums.length;
        int[][] masks = new int[n][32];
        int idx = 0;
        for(int num : nums)
        {
            masks[idx] = convertToBits(num);
            idx++;
        }
        int s = 0;
        int e = 0;
        int ans = 0;
        int inValidCount = 0;
        while(e < n)
        {
            int i = 0;
            for(int bit : masks[e])
            {
                bitMap[i] += bit;
                if(bitMap[i] > 1)
                {
                    inValidCount++;
                }
                i++;
            }
            e++;
            while(inValidCount > 0)
            {
                i = 0;
                for(int bit : masks[s])
                {
                    bitMap[i] -= bit;
                    if(bitMap[i] == 1 && bit == 1)
                    {
                        inValidCount--;
                    }
                    i++;
                }
                s++;
            }
            ans = Math.max(ans, e - s);
        }
        return ans;
    }
    private int[] convertToBits(int num)
    {
        int[] ans = new int[32];
        int idx = 0;
        while(idx < 32)
        {
            if((num&(1<<idx)) > 0)
            {
                ans[31 - idx] = 1;
            }
            idx++;
        }
        return ans;
    }
}