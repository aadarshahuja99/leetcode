class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;
        for(int i=n-2; i>=0; i--)
        {
            if(nums[i] <= nums[i+1])
            {
                continue;
            }
            if(nums[i]%2 == 0)
            {
                nums[i] = 2;
                ops++;
            }
            else
            {
                nums[i] = getProperDivisionAnswer(nums[i]);
                if(nums[i] > nums[i+1])
                {
                    return -1;
                }
                ops++;
            }
        }
        return ops;
    }
    private int getProperDivisionAnswer(int num)
    {
        int temp = num;
        for(int p=3; p*p <= temp; p++)
        {
            if(num%p == 0)
            {
                return p;
            }
        }
        // System.out.println(ans+" for "+num);
        return num;
    }
}