class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        for(int i=0; i<s.length();)
        {
            char c = s.charAt(i);
            // System.out.println(c);
            if(c == '(')
            {
                StringBuilder current = new StringBuilder();
                int j=i+1;
                while(j < s.length() && s.charAt(j) != '(' && s.charAt(j) != ')')
                {
                    current.append(s.charAt(j));
                    j++;
                }
                // System.out.println(current.toString());
                stack.push(current);
                i=j;
            }
            else if(c == ')')
            {
                var top = stack.pop();
                var reversed = top.reverse();
                if(stack.isEmpty())
                {
                    stack.push(reversed);
                }
                else
                {
                    var prev = stack.pop();
                    var pushed = prev.append(reversed);
                    // System.out.println(pushed.toString()+" "+stack.size());
                    stack.push(pushed);
                }
                i++;
            }
            else
            {
                StringBuilder current = new StringBuilder();
                int j=i;
                while(j < s.length() && s.charAt(j) != '(' && s.charAt(j) != ')')
                {
                    current.append(s.charAt(j));
                    j++;
                }
                if(stack.isEmpty())
                {
                    stack.push(current);
                }
                else
                {
                    var top = stack.pop();
                    stack.push(top.append(current));
                }
                i=j;
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}