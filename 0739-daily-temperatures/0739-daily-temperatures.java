class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[temperatures.length];
        stack.push(temperatures.length-1);
        for(int j=temperatures.length-2; j>=0; j--)
        {
            while(stack.size() > 0 && temperatures[stack.peek()] <= temperatures[j])
            {
                stack.pop();
            }
            if(stack.size() == 0)
            {
                ans[j] = 0;
            }
            else
            {
                ans[j] = stack.peek()-j;
            }
            stack.push(j);
        }
        return ans;
    }
}