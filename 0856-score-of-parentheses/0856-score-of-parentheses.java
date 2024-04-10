class Solution {
    public int scoreOfParentheses(String s) {
        // intuitive solution:
        // push 0 to stack for each '('
        // if current == ')', and stack top == 0 ? pop the top and push 1 to stack.
        // Else if top != 0, keep popping and adding non zero elements from the stack until the top becomes 0. Pop the top and multiply the 
        // sum with 2
        Stack<Integer> stack = new Stack<Integer>();
        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                stack.push(0);
            }
            else
            {
                if(stack.peek() == 0)
                {
                    stack.pop();
                    stack.push(1);
                }
                else
                {
                    int sum = 0;
                    while(stack.peek() != 0)
                    {
                        sum += stack.pop();
                    }
                    stack.pop();
                    stack.push(2*sum);
                }
            }
        }
        int ans = 0;
        while(!stack.isEmpty())
        {
            ans += stack.pop();
        }
        return ans;
    }
}