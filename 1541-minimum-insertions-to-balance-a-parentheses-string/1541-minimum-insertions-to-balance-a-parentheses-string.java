class Solution {
    public int minInsertions(String s) {
        // stack with encoding. Similar question: longest valid parenthesis substring
        // for '(': 
        //      1. if empty stack or 2 at top? push 2 to stack
        //.     2. else, (if 1 at top), need to add a ')' for the 1 at top, incr ans, pop, then push 2
        // for ')':
        //.     1. if empty stack, push 1 to the stack, incr the ans (for adding an '(' for the current ')')
        //.     2. else, if 1 at the top, pop the 1
        //      3. Else, (if top==2), make the top as 1 and continue
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                if(stack.isEmpty() || stack.peek() == 2)
                {
                    stack.push(2);
                }
                else
                {
                    ans++;
                    stack.pop();
                    stack.push(2);
                }
            }
            else
            {
                if(stack.isEmpty())
                {
                    stack.push(1);
                    ans++; // adding an '('
                }
                else if(stack.peek() == 2)
                {
                    stack.pop();
                    stack.push(1);
                }
                else
                {
                    stack.pop();
                }
            }
        }
        while(stack.size() > 0)
        {
            ans += stack.pop();
        }
        return ans;
    }
}