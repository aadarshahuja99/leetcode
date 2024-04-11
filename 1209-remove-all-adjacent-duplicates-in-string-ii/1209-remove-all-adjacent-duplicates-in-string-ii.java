class Solution {
    public String removeDuplicates(String s, int k) {
        LinkedList<int[]> stack = new LinkedList<int[]>();
        for(char c : s.toCharArray())
        {
            int alphabetIndex = c-97;
            if(stack.isEmpty())
            {
                stack.addLast(new int[] { alphabetIndex,1 });
            }
            else
            {
                if(stack.getLast()[0] == alphabetIndex && stack.getLast()[1] == k-1)
                {
                    while(!stack.isEmpty() && stack.getLast()[0] == alphabetIndex)
                    {
                        stack.removeLast();
                    }
                }
                else if(stack.getLast()[0] == alphabetIndex)
                {
                    stack.addLast(new int[] { alphabetIndex, stack.getLast()[1] + 1 });
                }
                else
                {
                    stack.addLast(new int[] { alphabetIndex,1 });
                }
            }
        }
        if(stack.isEmpty())
        {
            return "";
        }
        char[] chars = new char[stack.size()];
        int idx = 0;
        for(int[] element : stack)
        {
            chars[idx] = (char)(element[0] + 97);
            idx++;
        }
        return new String(chars);
    }
}