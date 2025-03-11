class Solution {
    public boolean increasingTriplet(int[] nums) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int n = nums.length;
        int[] nsls = new int[n];
        int[] ngrs = new int[n];
        nsls[0] = -1;
        ngrs[n-1] = -1;
        stack1.push(0);
        for(int i=1; i<n; i++)
        {
            while(stack1.size() > 0 && nums[stack1.peek()] >= nums[i])
            {
                stack1.pop();
            }
            if(stack1.size() == 0)
            {
                nsls[i] = -1;
            }
            else
            {
                nsls[i] = stack1.peek();
            }
            stack1.push(i);
        }

        stack2.push(n-1);
        for(int i=n-2; i>=0; i--)
        {
            while(stack2.size() > 0 && nums[stack2.peek()] <= nums[i])
            {
                stack2.pop();
            }
            if(stack2.size() == 0)
            {
                ngrs[i] = -1;
            }
            else
            {
                ngrs[i] = stack2.peek();
            }
            stack2.push(i);
        }

        for(int i=1; i<n-1; i++)
        {
            if(nsls[i] != -1 && ngrs[i] != -1)
            {
                return true;
            }
        }
        return false;
    }
}