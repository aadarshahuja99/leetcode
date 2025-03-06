class Solution {
    public String removeKdigits(String num, int k) {
        // maintain a monotonic increasing stack
        Stack<Integer> stack = new Stack<>();
        for(char c : num.toCharArray())
        {
            int val = c - '0';
            while(!stack.isEmpty() && stack.peek() > val && k > 0)
            {
                stack.pop();
                k--;
            }
            stack.push(val);
        }
        while(k > 0)
        {
            stack.pop();
            k--;
        }
        if(stack.size() == 0)
        {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0)
        {
            sb.append((char)(stack.pop() + '0'));
        }
        String intermediate = sb.reverse().toString();
        int idx = 0;
        StringBuilder ans = new StringBuilder();
        while(idx < intermediate.length() && intermediate.charAt(idx) == '0')
        {
            idx++;
        }
        while(idx < intermediate.length())
        {
            ans.append(intermediate.charAt(idx));
            idx++;
        }
        if(ans.length() == 0)
        {
            return "0";
        }
        return ans.toString();
    }
}