class Solution {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        int[] nsr = new int[n];
        int[] ngr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                ngr[i] = -1;
            }
            else
            {
                ngr[i] = stack.peek();
            }
            stack.push(i);
            // System.out.println(ngr[i]+" ngr for "+i);
        }
        stack.clear();
        for(int i=n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                nsr[i] = -1;
            }
            else
            {
                nsr[i] = stack.peek();
            }
            stack.push(i);
            // System.out.println(nsr[i]+" nsr for "+i);
        }
        long[] cache = new long[n];
        Arrays.fill(cache, -1);
        return getAns(0, costs, ngr, nsr, cache);
    }
    private long getAns(int current, int[] costs, int[] ngrs, int[] nsrs, long[] cache)
    {
        if(current == costs.length-1)
        {
            return 0l;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        int greater = ngrs[current];
        long cost = 1_00000_00001l;
        if(greater != -1)
        {
            long candidate = getAns(greater, costs, ngrs, nsrs, cache);
            if(candidate != 1_00000_00001l)
            {
                cost = Math.min(cost, costs[greater]*1l + candidate);
            }
        }
        int smaller = nsrs[current];
        if(smaller != -1)
        {
            long candidate = getAns(smaller, costs, ngrs, nsrs, cache);
            if(candidate != 1_00000_00001l)
            {
                cost = Math.min(cost, costs[smaller]*1l + candidate);
            }
        }
        return cache[current] = cost;
    }
}