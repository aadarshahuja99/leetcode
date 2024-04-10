class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int min = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(min >= nums[i])
            {
                min = nums[i];
                continue;
            }
            else
            {
                // consider the case:  3,5,0,2 ..... the next element can either be 2 or 4 for example, we have to support both cases
                while(stack.size() > 0 && (stack.peek()[0] <= nums[i]))
                {
                    stack.pop();
                }
                if(stack.size() > 0 && stack.peek()[0] > nums[i] && stack.peek()[1] < nums[i])
                {
                    return true;
                }
                stack.push(new int[] { nums[i], min });
            }
        }
        return false;
    }
}