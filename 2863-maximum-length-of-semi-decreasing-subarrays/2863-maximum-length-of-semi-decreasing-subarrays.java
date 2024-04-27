class Solution {
    public int maxSubarrayLength(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        stack.push(0);
        // a small variation of maximum width ramp. Instead of nums[i] <= nums[j], we have nums[i] > nums[j] in the question
        // 2 traversals will be needed. A smaller element at a later position must get the privilege of choosing a larger element at an earlier position.
        for(int i=1; i<n; i++)
        {
            if(nums[stack.peek()] <= nums[i])
            {
                stack.push(i);
            }
        }
        int maxLength = 0;
        for(int i=n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
            {
                maxLength = Math.max(maxLength, i - stack.peek() + 1);
                stack.pop();
            }
        }
        return maxLength;
    }
}