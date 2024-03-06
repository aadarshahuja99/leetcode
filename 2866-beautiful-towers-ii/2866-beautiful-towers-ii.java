class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] nsls = new long[n];
        long[] nsrs = new long[n];
        Stack<long[]> stack1 = new Stack<long[]>();
        Stack<long[]> stack2 = new Stack<long[]>();
        nsls[0] = 0;
        nsrs[n-1] = 0;
        stack1.push(new long[] { 0, 0 });
        stack2.push(new long[] { n-1, 0 });
        for(int i=1; i<n; i++)
        {
            long num = maxHeights.get(i);
            while(stack1.size() > 0 && maxHeights.get((int)stack1.peek()[0]) >= maxHeights.get(i))
            {
                stack1.pop();
            }
            if(stack1.size() == 0)
            {
                nsls[i] = num*i;
            }
            else
            {
                nsls[i] = (i-stack1.peek()[0]-1)*num + stack1.peek()[1] + maxHeights.get((int)stack1.peek()[0]);
            }
            stack1.push(new long[] { i, nsls[i] });
        }

        for(int i=n-2; i>=0; i--)
        {
            long num = maxHeights.get(i);
            while(stack2.size() > 0 && maxHeights.get((int)stack2.peek()[0]) >= maxHeights.get(i))
            {
                stack2.pop();
            }
            if(stack2.size() == 0)
            {
                nsrs[i] = num*(n-1-i);
            }
            else
            {
                nsrs[i] = (stack2.peek()[0]-1-i)*num + stack2.peek()[1] + maxHeights.get((int)stack2.peek()[0]);
            }
            stack2.push(new long[] { i, nsrs[i] });
        }
        
        long ans = Long.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            // System.out.println(nsls[i] + " " + nsrs[i]);
            long current = maxHeights.get(i) + nsls[i] + nsrs[i];
            // if(nsls[i] < 0 || nsrs[i] < 0 || current < 0)
            // {
            //     System.out.println("true");
            // }
            ans = Math.max(current, ans);
        }
        return ans;
    }
}