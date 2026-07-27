class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n = nums.length;
        return kSumHelper(0, n-1, target*1l, 4, clone);
    }
    private List<List<Integer>> kSumHelper(int start, int end, long target, int k, int[] nums)
    {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(start == end)
        {
            return ans;
        }
        if(k == 2)
        {
            return twoSumHelper(start, end, target, nums);
        }
        int n = nums.length;
        for(int i=start; i<end-1; i++)
        {
            if(i > start && nums[i] == nums[i-1])
            {
                continue;
            }
            var subsets = kSumHelper(i+1, end, target - 1l*nums[i], k-1, nums);
            // add current element to all valid subsets that meet the criteria
            for(var subset : subsets)
            {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subset);
                ans.add(list);
            }
        }
        return ans;
    }
    private List<List<Integer>> twoSumHelper(int start, int end, long target, int[] nums)
    {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int j=start;
        int k=end;
        while(j < k)
        {
            long current = 1l*nums[j]+1l*nums[k];
            if(current == target)
            {
                // we have a candidate
                ans.add(Arrays.asList(nums[j], nums[k]));
                j++;
                while(j < k && nums[j] == nums[j-1])
                {
                    j++;
                }
                k--;
                while(j < k && nums[k] == nums[k+1])
                {
                    k--;
                }
            }
            else if(current < target)
            {
                j++;
            }
            else
            {
                k--;
            }
        }
        return ans;
    }
}