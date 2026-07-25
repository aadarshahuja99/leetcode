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
                // find the valid segment(s) that appear before this closing ')'
                int sum = 0;
                while(!stack.isEmpty() && stack.peek() != 1)
                {
                    sum += stack.pop();
                }
                if(stack.isEmpty())
                {
                    // extra ')' is encountered. No need to push it to stack and the popped segment can be seen as a candidate as the extra ')' in between will stop it from combining with the next valid segment
                    ans = Math.max(ans,sum);
                }
                else
                {
                    // the current ')' has found a corresponding '(', so it can be a part of the segment
                    // update the current valid segment by adding a wrapper of '()' around it
                    stack.pop();
                    stack.push(2+sum);
                }
            }
        }
        while(!stack.isEmpty())
        {
            int popped = stack.pop();
            if(popped == 1)
            {
                // extra '(' is encountered, it will result in the candidate not being formed
                continue;
            }
            int candidate = popped;
            while(!stack.isEmpty() && stack.peek() != 1)
            {
                candidate += stack.pop();
            }
            ans = Math.max(ans, candidate);
        }
        return ans;
    }
}