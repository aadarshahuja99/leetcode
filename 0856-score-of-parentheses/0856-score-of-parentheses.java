class Solution {
    public int scoreOfParentheses(String s) {
        if(s.length() == 2)
        {
            return 1;
        }
        s = "("+s+")";
        int[] pairs = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(char c : s.toCharArray())
        {
            if(c=='(')
            {
                stack.push(i);
                i++;
            }
            else
            {
                pairs[i] = stack.peek();
                pairs[stack.peek()] = i;
                stack.pop();
                i++;
            }
        }
        return (getAns(0,s.length()-1,pairs))/2;
    }
    private int getAns(int start, int end, int[] pairs)
    {
        if(start == end-1)
        {
            return 1;
        }
        int ans = 0;
        int idx = start+1;
        while(idx<end)
        {
            ans += getAns(idx,pairs[idx],pairs);
            idx = pairs[idx]+1;
        }
        return ans*2;
    }
}