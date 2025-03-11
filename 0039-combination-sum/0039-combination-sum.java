class Solution {
    ArrayList<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        getAns(0, target, candidates, new ArrayList<Integer>());
        return ans;
    }
    private void getAns(int current, int target, int[] nums, ArrayList<Integer> list)
    {
        if(current == nums.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(target == 0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(nums[current] > target)
        {
            return;
        }
        list.add(nums[current]);
        getAns(current, target - nums[current], nums, list);
        list.remove(list.size() - 1);
        getAns(current+1, target, nums, list);
    }
}