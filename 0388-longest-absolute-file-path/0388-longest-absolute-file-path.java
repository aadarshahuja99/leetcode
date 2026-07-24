class Solution {
    public int lengthLongestPath(String input) {
        Stack<int[]> stack = new Stack<>();
        int maxLength = 0;
        // Intuition: stack stores int[2] in the form {numberOfTabs (to determine the parent of the uninserted element), component (file or folder) length - number of tabs in its path}. Tabs are removed as during answer computation, the file component's length tabs already contain the total number of tabs needed to reach the file
        for(String component : input.split("\n"))
        {
            int tabs = getNumberOfTabs(component);
            while(stack.size() > 0 && tabs <= stack.peek()[0])
            {
                // find the current component's parent
                stack.pop();
            }
            boolean isAFile = isFile(component);
            if(stack.size() == 0)
            {
                if(isAFile)
                {
                    maxLength = Math.max(maxLength, component.length());
                }
                stack.push(new int[] { tabs, component.length() - tabs });
            }
            else
            {
                if(isAFile)
                {
                    maxLength = Math.max(maxLength, stack.peek()[1] + component.length());
                }
                stack.push(new int[] { tabs, (component.length() - tabs) + stack.peek()[1] });
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