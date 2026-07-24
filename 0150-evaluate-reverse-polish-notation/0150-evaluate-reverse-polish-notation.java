class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> operands = new HashSet<>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");
        for(String token : tokens)
        {
            if(!operands.contains(token))
            {
                stack.push(Integer.parseInt(token));
            }
            else
            {
                int top = stack.pop();
                int second = stack.pop();
                if(token.equals("+"))
                {
                    stack.push(top+second);
                }
                else if(token.equals("-"))
                {
                    stack.push(second-top);
                }
                else if(token.equals("*"))
                {
                    stack.push(top*second);
                }
                else
                {
                    stack.push(second/top);
                }
            }
        }
        return stack.peek();
    }
}