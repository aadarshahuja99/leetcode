class Solution {
    public int minInsertions(String s) {
        Stack<Integer> stack = new Stack<>();
        int diff=0;
        int openDiff=0;
        int idx = 0;
        int halfDiff=0;
        while(idx < s.length())
        {
            char c = s.charAt(idx);
            if(c == '(')
            {
                if(stack.size() > 0 && stack.peek() == 1)
                {
                    openDiff++;
                    stack.pop();
                }
                stack.push(2);
            }
            else
            {
                if(stack.size() == 0)
                {
                    if(idx+1 < s.length() && s.charAt(idx+1) == ')')
                    {
                        diff++;
                        idx++;
                    }
                    else
                    {
                        halfDiff++;
                    }
                }
                else
                {
                    int currCount = stack.pop();
                    if(currCount == 2)
                    {
                        stack.push(1);
                    }
                }
            }
            idx++;
        }
        int stackDiff = 0;
        while(stack.size() > 0)
        {
            stackDiff += stack.pop();
        }
        return openDiff + stackDiff + diff + halfDiff*2;
    }
}