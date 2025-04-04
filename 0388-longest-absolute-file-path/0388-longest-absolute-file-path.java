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
                // we only push the length of the path without tabs count in the second parameter, if there is a file after the current path, then the file component's number of tabs will be equal to the total number of slashes needed in the file path length, which is why only component.length() + stack.peek()[1] is done in answer computation
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