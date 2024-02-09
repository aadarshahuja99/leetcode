class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0)
        {
            return nums;
        }
        long[] ans = new long[nums.length];
        int[] finalans = new int[nums.length];
        if(k > nums.length/2)
        {
            Arrays.fill(ans,-1);
            for(int idx=0; idx<nums.length; idx++)
            {
                finalans[idx] = (int)ans[idx];
            }
            return finalans;
        }
        long[] pre = new long[nums.length];
        long[] post = new long[nums.length];
        pre[0] = 0;
        post[nums.length-1] = 0;
        for(int i=1; i<nums.length; i++)
        {
            pre[i] = nums[i-1]+pre[i-1];
        }
        for(int i=nums.length-2; i>=0; i--)
        {
            post[i] = nums[i+1]+post[i+1];
        }
        for(int i=0; i<k; i++)
        {
            ans[i] = -1;
        }
        for(int j=nums.length-1; j>nums.length-1-k; j--)
        {
            ans[j] = -1;
        }
        for(int i=k; i<nums.length-k; i++)
        {
            // System.out.println(pre[i]+" "+post[i]+" "+((nums[i]+pre[i]-pre[i-k]+post[i]-post[i+k])/((2*k) + 1)));
            ans[i] = ((nums[i]+pre[i]-pre[i-k]+post[i]-post[i+k]))/((2*k) + 1);
        }
        for(int idx=0; idx<nums.length; idx++)
        {
            finalans[idx] = (int)ans[idx];
        }
        return finalans;
    }
}