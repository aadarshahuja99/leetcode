class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] ngrs = new int[n];
        ngrs[n-1] = -1;
        stack.push(n-1);
        for(int i=n-2; i>=0; i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] < heights[i])
            {
                stack.pop();
            }
            if(stack.size() > 0)
            {
                ngrs[i] = stack.peek();
            }
            else
            {
                ngrs[i] = -1;
            }
            stack.push(i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            if(ngrs[i] == -1)
            {
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        int idx = 0;
        for(int num : list)
        {
            arr[idx] = num;
            idx++;
        }
        return arr;
    }
}