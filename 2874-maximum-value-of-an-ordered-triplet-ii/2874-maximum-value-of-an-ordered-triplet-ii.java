class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] maxSoFar = new int[n];
        int[] maxAfter = new int[n];
        long ans = Long.MIN_VALUE;
        int max = -1;
        maxSoFar[0] = max;
        for(int i=1; i<n; i++)
        {
            max = Math.max(max, nums[i-1]);
            maxSoFar[i] = max;
        }
        max = -1;
        for(int i=n-2; i>=1; i--)
        {
            max = Math.max(max, nums[i+1]);
            // System.out.println(nums[i]+" "+maxSoFar[i]+" "+maxAfter[i]);
            long score = ((long)maxSoFar[i] - (long)nums[i])*(long)max;
            ans = Math.max(score, ans);
        }
        return ans < 0l ? 0l : ans;
    }
}