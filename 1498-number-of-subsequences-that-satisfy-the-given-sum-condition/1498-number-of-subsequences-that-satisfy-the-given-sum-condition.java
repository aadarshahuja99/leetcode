class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        int j=n-1;
        ArrayList<Integer> powers = new ArrayList<>();
        powers.add(1);
        int modulo = 1000000007;
        for(int it=1; it<nums.length; it++)
        {
            powers.add((powers.get(it-1)<<1)%modulo);
        }
        while(j >= 0 && nums[i]+nums[j] > target)
        {
            j--;
        }
        if(j < 0)
        {
            return 0;
        }
        int ans = 0;
        while(i <= j)
        {
            if(nums[i] + nums[j] <= target)
            {
                int numsBetween = j-i;
                ans = (ans%modulo + powers.get(numsBetween))%modulo;
                i++;
            }
            else
            {
                j--;
            }
        }
        return ans;
    }
}