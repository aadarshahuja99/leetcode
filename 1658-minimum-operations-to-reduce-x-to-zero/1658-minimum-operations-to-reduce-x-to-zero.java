class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int i=0;
        int n = nums.length;
        while(sum < x && i < n)
        {
            sum += nums[i];
            i++;
        }
        if(i == n)
        {
            if(sum == x)
            {
                return n;
            }
            else if(sum < x)
            {
                return -1;
            }
        }
        int ans = -1;
        if(sum == x)
        {
            ans = i;
        }
        // System.out.println(sum+", "+i);
        i--;
        int j=n-1;
        while(j >= 0)
        {
            sum += nums[j];
            // System.out.println(sum+" after adding "+j);
            while(i >= 0 && sum > x)
            {
                sum -= nums[i];
                i--;
            }
            // System.out.println(sum+" after reducing i to "+i);
            if(sum == x)
            {
                if(ans == -1)
                {
                    ans = i + 1 + (n - j);
                }
                else
                {
                    ans = Math.min(ans, i + 1 + (n - j));
                }
            }
            j--;
        }
        return ans;
    }
}