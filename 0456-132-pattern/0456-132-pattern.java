class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int min = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(min >= nums[i])
            {
                min = nums[i];
            }
            else
            {
                // stack stores int[2] { previousGreater element, min seen till that element } It is a mono decreasing stack on the previous greater element
                // consider the case:  3,5,0,2 ..... the next element can either be 1 or 4 for example, we have to support both cases
                while(stack.size() > 0 && (stack.peek()[0] <= nums[i]))
                {
                    stack.pop();
                }
                if(stack.size() > 0 && stack.peek()[1] < nums[i])
                {
                    return true;
                }
                stack.push(new int[] { nums[i], min });
            }
        }
        return false;
    }
}