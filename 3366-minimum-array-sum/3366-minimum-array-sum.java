class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length;
        int[][][] cache = new int[n][op1+1][op2+1];
        for(int[][] nr : cache)
        {
            for(int[] r : nr)
            {
                Arrays.fill(r,-1);
            }
        }
        return getAns(0, op1, op2, k, nums, cache);
    }
    private int getAns(int current, int op1, int op2, int k, int[] nums, int[][][] cache)
    {
        int n = nums.length;
        if(current == n)
        {
            return 0;
        }
        if(cache[current][op1][op2] != -1)
        {
            return cache[current][op1][op2];
        }
        int proceed = nums[current] + getAns(current+1, op1, op2, k, nums, cache);
        int do1 = Integer.MAX_VALUE;
        int do2 = Integer.MAX_VALUE;
        int do1And2 = Integer.MAX_VALUE;
        int do2And1 = Integer.MAX_VALUE;
        if(op1 > 0)
        {
            int v = (int)Math.ceil((double)nums[current]/2.0);
            do1 = v + getAns(current+1, op1-1, op2, k, nums, cache);
            if(op2 > 0 && v >= k)
            {
                do1And2 = v-k + getAns(current+1, op1-1, op2-1, k, nums, cache);
            }
        }
        if(op2 > 0 && nums[current] >= k)
        {
            int v = nums[current]-k;
            do2 = v + getAns(current+1, op1, op2-1, k, nums, cache);
            if(op1 > 0)
            {
                do2And1 = (int)Math.ceil((double)v/2.0) + getAns(current+1, op1-1, op2-1, k, nums, cache);
            }
        }
        return cache[current][op1][op2] = Math.min(proceed, Math.min(Math.min(do1, do1And2), Math.min(do2, do2And1)));
    }
}