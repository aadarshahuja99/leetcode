class Solution {
    Stack<Character> stack = new Stack<>();
    HashMap<Character,Character> map = new HashMap<>();
    public boolean isValid(String s) {
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        for(char ch : s.toCharArray())
        {
            if(ch == ')' || ch == '}' || ch == ']')
            {
                if(!validate(ch, map.get(ch)))
                {
                    return false;
                }
            }
            else
            {
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }
    private boolean validate(char ch, char expected)
    {
        if(stack.isEmpty() || stack.peek() != expected)
        {
            return false;
        }
        stack.pop();
        return true;
    }
}