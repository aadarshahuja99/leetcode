class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] > ans.get(ans.size()-1))
            {
                ans.add(nums[i]);
                continue;
            }
            int ceil = getCeil(nums[i], ans);
            ans.set(ceil, nums[i]);
        }
        return ans.size();
    }
    private int getCeil(int t, List<Integer> nums)
    {
        int s = 0, e = nums.size()-1;
        int ans = -1;
        while(s <= e)
        {
            int mid = s + (e-s)/2;
            if(nums.get(mid) >= t)
            {
                ans = mid;
                e = mid-1;
            }
            else
            {
                s = mid+1;
            }
        }
        return ans;
    }
}