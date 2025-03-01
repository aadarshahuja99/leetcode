class Solution {
    public long getDescentPeriods(int[] nums) {
        // 2 pointers approach
        int i=0;
        int n = nums.length;
        long ans = 0;
        while(i < n)
        {
            int j=i+1;
            int last = nums[i];
            while(j < n && nums[j] == last-1)
            {
                last = nums[j];
                j++;
            }
            ans += 1l*(j-i)*(j-i+1)/2l;
            i = j;
        }
        return ans;
    }
}