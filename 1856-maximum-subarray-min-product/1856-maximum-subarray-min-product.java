class Solution {
    public int maxSumMinProduct(int[] nums) {
        // subarray of minimums
        int n = nums.length;
        int[] nearestSmallerToLeft = new int[n];
        int[] nearestSmallerToRight = new int[n];
        nearestSmallerToLeft[0] = -1;
        nearestSmallerToRight[n-1] = -1;

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        
        long[] pre = new long[n];
        pre[0] = (long)nums[0];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1] + (long)nums[i];
        }

        leftStack.push(0);
        for(int i=1; i<n; i++)
        {
            while(!leftStack.isEmpty() && nums[leftStack.peek()] >= nums[i])
            {
                leftStack.pop();
            }
            if(leftStack.size() == 0)
            {
                nearestSmallerToLeft[i] = -1;
            }
            else
            {
                nearestSmallerToLeft[i] = leftStack.peek();
            }
            leftStack.push(i);
        }


        rightStack.push(n-1);
        for(int i=n-2; i>=0; i--)
        {
            while(!rightStack.isEmpty() && nums[rightStack.peek()] > nums[i])
            {
                rightStack.pop();
            }
            if(rightStack.size() == 0)
            {
                nearestSmallerToRight[i] = -1;
            }
            else
            {
                nearestSmallerToRight[i] = rightStack.peek();
            }
            rightStack.push(i);
        }

        long ans = 0;
        int modulo = 1000000007;
        for(int i=0; i<n; i++)
        {
            // System.out.println(i+" "+nearestSmallerToRight[i]+" "+nearestSmallerToLeft[i]);
            if(nearestSmallerToLeft[i] == -1 && nearestSmallerToRight[i] == -1)
            {
                ans = Math.max(ans, pre[n-1]*(long)nums[i]);
            }
            else
            {
                long sum = 0l;
                if(nearestSmallerToLeft[i] != -1 && nearestSmallerToRight[i] == -1)
                {
                    sum = pre[n-1] - pre[nearestSmallerToLeft[i]];
                }
                else if(nearestSmallerToLeft[i] == -1 && nearestSmallerToRight[i] != -1)
                {
                    sum = pre[nearestSmallerToRight[i]-1];
                }
                else
                {
                    sum = pre[nearestSmallerToRight[i]-1] - pre[nearestSmallerToLeft[i]];
                }
                ans = Math.max(ans, sum*(long)nums[i]);
            }
        }
        return (int)(ans%modulo);
    }
}