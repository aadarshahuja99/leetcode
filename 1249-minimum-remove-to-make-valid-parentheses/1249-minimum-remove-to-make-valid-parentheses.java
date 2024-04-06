class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        HashSet<Integer> closingParenthesesToBeRemoved = new HashSet<>();
        for(char c : s.toCharArray())
        {
            if(c != '(' && c != ')')
            {
                idx++;
                continue;
            }
            else if(c == '(')
            {
                stack.push(idx);
            }
            else
            {
                if(stack.size() > 0)
                {
                    stack.pop();
                }
                else
                {
                    closingParenthesesToBeRemoved.add(idx);
                }
            }
            idx++;
        }
        int answerLength = s.length() - stack.size() - closingParenthesesToBeRemoved.size();
        if(answerLength == s.length())
        {
            return s;
        }
        char[] answer = new char[answerLength];
        for(int i = s.length() - 1, j = answerLength-1; j >= 0; i--)
        {
            if(closingParenthesesToBeRemoved.contains(i))
            {
                continue;
            }
            if(stack.size() > 0 && stack.peek() == i)
            {
                stack.pop();
                continue;
            }
            answer[j] = s.charAt(i);
            j--;
        }
        return new String(answer);
    }
}