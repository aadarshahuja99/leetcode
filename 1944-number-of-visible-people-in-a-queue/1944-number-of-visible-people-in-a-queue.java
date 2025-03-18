class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        return getNearestGreaterToRightDistances(heights);
    }
    private int[] getNearestGreaterToRightDistances(int[] heights)
    {
        int[] ans = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        ans[heights.length-1] = 0;
        stack.push(heights[heights.length-1]);
        for(int i=heights.length-2; i>=0; i--)
        {
            int count = 0;
            while(stack.size() > 0 && stack.peek() < heights[i])
            {
                stack.pop();
                count++;
            }
            if(stack.size() > 0)
            {
                count++;
            }
            ans[i] = count;
            stack.push(heights[i]);
        }
        return ans;
    }
}