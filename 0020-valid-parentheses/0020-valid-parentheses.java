class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(ch == ')' || ch == '}' || ch == ']')
            {
                if(stack.size() == 0)
                {
                    return false;
                }
                if(ch == ')' && stack.peek() != '(')
                {
                    return false;
                }
                else if(ch == ')')
                {
                    stack.pop();
                }

                if(ch == '}' && stack.peek() != '{')
                {
                    return false;
                }
                else if(ch == '}')
                {
                    stack.pop();
                }

                if(ch == ']' && stack.peek() != '[')
                {
                    return false;
                }
                else if(ch == ']')
                {
                    stack.pop();
                }
            }
            else
            {
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }
}