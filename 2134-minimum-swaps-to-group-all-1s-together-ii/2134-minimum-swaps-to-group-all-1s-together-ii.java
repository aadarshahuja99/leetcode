class Solution {
    public int minSwaps(int[] nums) {
        // fixed size sliding window question
        int total = 0;
        for(int num : nums)
        {
            if(num == 1)
            {
                total++;
            }
        }
        int j=0;
        int i=0;
        int current = 0;
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        if(total == 0 || total == n)
        {
            return 0;
        }
        int[] updated = new int[2*n];
        for(int k=0; k<2*n; k++)
        {
            updated[k] = nums[k%n];
        }
        while(j < 2*n)
        {
            // consume 'j'
            if(updated[j] == 1)
            {
                current++;
            }
            j++;
            if(j - i == total)
            {
                // System.out.println(j+", "+i+" total-current: "+(total-current));
                ans = Math.min(ans, total - current);
                if(updated[i] == 1)
                {
                    current--;
                }
                i++;
            }
        }
        return ans;
    }
}