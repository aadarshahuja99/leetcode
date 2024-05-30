class Solution {
    public int lengthLongestPath(String input) {
        Stack<int[]> stack = new Stack<>();
        int maxLength = 0;
        for(String component : input.split("\n"))
        {
            int tabs = getNumberOfTabs(component);
            while(stack.size() > 0 && tabs <= stack.peek()[0])
            {
                stack.pop();
            }
            boolean isAFile = isFile(component);
            if(stack.size() == 0)
            {
                // System.out.println((component.length()) + "  " + tabs + " " + maxLength);
                if(isAFile)
                {
                    maxLength = Math.max(maxLength, component.length());
                }
                stack.push(new int[] { tabs, component.length() });
            }
            else
            {
                if(isAFile)
                {
                    maxLength = Math.max(maxLength, stack.peek()[1] + component.length());
                }
                // System.out.println((component.length() - tabs + stack.peek()[1]) + "  " + tabs + " " + maxLength);
                stack.push(new int[] { tabs, component.length() + stack.peek()[1] - tabs });
            }
        }
        return maxLength;
    }
    private int getNumberOfTabs(String str)
    {
        int i=0;
        while(i < str.length() && str.charAt(i) == '\t')
        {
            i++;
        }
        return i;
    }
    private boolean isFile(String s)
    {
        return s.indexOf(".") != -1;
    }
}