class Solution {
    public int maximalRectangle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[n];
        int ans = -1;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    if(i == 0 || grid[i-1][j] == '1')
                    {
                        nums[j]++;
                    }
                    else
                    {
                        nums[j] = 1;
                    }
                }
                else
                {
                    nums[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(nums));
        }
        return ans;
    }
    private int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++)
        {
            while(stack.size() > 0 && nums[stack.peek()] >= nums[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                prevSmaller[i] = 0;
            }
            else
            {
                prevSmaller[i] = stack.peek()+1;
            }
            stack.push(i);
        }
        stack.clear();
        int ans = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--)
        {
            while(stack.size() > 0 && nums[stack.peek()] >= nums[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                nextSmaller[i] = n-1;
            }
            else
            {
                nextSmaller[i] = stack.peek()-1;
            }
            stack.push(i);
            ans = Math.max(ans, nums[i]*(nextSmaller[i]-prevSmaller[i]+1));
        }
        return ans;
    }
}