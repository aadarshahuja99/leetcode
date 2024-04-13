class Solution {
    public long numberOfSubarrays(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        HashMap<Integer,Integer> runningCount = new HashMap<>();
        runningCount.put(nums[0], 1);
        stack.push(0);
        long ans = 0;
        for(int i=1; i<n; i++)
        {
            while(stack.size() > 0 && nums[stack.peek()] <= nums[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                ans += runningCount.getOrDefault(nums[i], 0);
            }
            else
            {
                int countInWindow = 0;
                for(int j=stack.peek()+1; j<i; j++)
                {
                    if(nums[j] == nums[i])
                    {
                        countInWindow++;
                    }
                }
                // System.out.println(countInWindow+" for "+i);
                ans += countInWindow;
            }
            stack.push(i);
            runningCount.put(nums[i], runningCount.getOrDefault(nums[i], 0) + 1);
        }
        return ans + n;
    }
}