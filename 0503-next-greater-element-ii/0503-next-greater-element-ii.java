class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=2*n-1; i>=0; i--)
        {
            int idx = i%n;
            while(stack.size() > 0 && nums[stack.peek()] <= nums[idx])
            {
                stack.pop();
            }
            if(stack.size() == 0)
            {
                ans[idx] = -1;
            }
            else
            {
                ans[idx] = nums[stack.peek()];
            }
            stack.push(idx);
        }
        return ans;
    }
}