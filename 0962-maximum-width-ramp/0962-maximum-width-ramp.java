class Solution {
    public int maxWidthRamp(int[] nums) {
        // create a decreasing stack. Because, an large element at a later position should get the privilege of choosing the smaller elements that had appeared earlier
        // example: [6,2,1,4,9,5] here: 5 should get the right to choose 1,2 because the distance from 5 for these 2 is the farthest, and the question requires us to get the farthest smaller/greater pair
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = nums.length;
        for(int i=1; i<n; i++)
        {
            if(nums[stack.peek()] > nums[i])
            {
                stack.push(i);
            }
        }
        int longestWidth = 0;
        for(int i=n-1; i>=0; i--)
        {
            while(stack.size() > 0 && nums[stack.peek()] <= nums[i])
            {
                longestWidth = Math.max(longestWidth, i - stack.peek());
                stack.pop();
            }
            if(stack.size() == 0)
            {
                break;
            }
        }
        return longestWidth;
    }
}