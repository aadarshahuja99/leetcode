class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> increasingStack = new Stack<>();
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
                // a possible j-value has been found
                if(increasingStack.isEmpty())
                {
                    increasingStack.push(new int[] { nums[i], min });
                }
                else if(increasingStack.peek()[0] > nums[i])
                {
                    if(increasingStack.peek()[1] < nums[i])
                    {
                        return true;
                    }
                    increasingStack.push(new int[] { nums[i], min });
                    // System.out.println(nums[i]+" "+increasingStack.peek()[0]);
                    // return true;
                }
                else
                {
                    while(!increasingStack.isEmpty() && increasingStack.peek()[0] <= nums[i])
                    {
                        increasingStack.pop();
                    }
                    increasingStack.push(new int[] { nums[i], min });
                }
            }
        }
        return false;
    }
}