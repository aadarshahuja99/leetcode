class Solution {
    public int minMoves(int[] nums, int k) {
        if(k <= 1)
        {
            return 0;
        }
        List<Integer> ones = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == 1)
            {
                ones.add(i);
            }
        }
        int[] pre = new int[ones.size()];
        pre[0] = ones.get(0);
        for(int i=1; i<ones.size(); i++)
        {
            pre[i] = pre[i-1] + ones.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=ones.size() - k; i++)
        {
            int medianIndex = ones.get(i + (k/2));
            int sumPost = pre[i+k-1] - pre[i + (k/2)];

            int numPost = k - (k/2) - 1;

            // System.out.println("Post: "+sumPost+", "+numPost+", "+medianIndex);
            int candidate = sumPost - numPost*medianIndex;
            int numPre = (k/2);
            
            int sumPre = pre[i + (k/2) - 1] - pre[i] + ones.get(i);
            
            // System.out.println("Pre: "+sumPre+", "+numPre+", "+medianIndex);
            
            candidate += numPre*medianIndex - sumPre;
            candidate -= (numPre*(numPre+1))/2;
            candidate -= (numPost*(numPost+1))/2;
            ans = Math.min(ans, candidate);
        }
        return ans;
    }
}