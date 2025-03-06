class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++)
        {
            while(stack.size() > 0 && nums[stack.peek()] >= nums[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                prevSmaller[i] = 0;
            }
            else
            {
                prevSmaller[i] = stack.peek()+1;
            }
            stack.push(i);
        }
        stack.clear();
        int ans = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--)
        {
            while(stack.size() > 0 && nums[stack.peek()] >= nums[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                nextSmaller[i] = n-1;
            }
            else
            {
                nextSmaller[i] = stack.peek()-1;
            }
            stack.push(i);
            // System.out.println(i+": "+prevSmaller[i]+","+nextSmaller[i]);
            ans = Math.max(ans, nums[i]*(nextSmaller[i]-prevSmaller[i]+1));
        }
        return ans;
    }
}