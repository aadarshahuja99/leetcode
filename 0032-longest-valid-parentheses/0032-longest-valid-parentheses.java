class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0)
        {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        int ans = 0;
        // similar logic as score of parentheses
        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                stack.push(1);
            }
            else
            {
                if(stack.size() == 0)
                {
                    continue;
                }
                int sum = 0;
                while(!stack.isEmpty() && stack.peek() != 1)
                {
                    sum += stack.pop();
                }
                if(stack.isEmpty())
                {
                    ans = Math.max(ans,sum);
                }
                else
                {
                    stack.pop();
                    stack.push(2+sum);
                }
            }
        }
        while(!stack.isEmpty())
        {
            if(stack.peek() == 1)
            {
                stack.pop();
                continue;
            }
            int candidate = 0;
            while(!stack.isEmpty() && stack.peek() != 1)
            {
                candidate += stack.pop();
            }
            ans = Math.max(ans, candidate);
        }
        return ans;
    }
}