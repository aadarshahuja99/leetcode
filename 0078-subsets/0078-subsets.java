class Solution {
    ArrayList<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        generate(0, new ArrayList<>(), nums);
        return ans;
    }
    private void generate(int current, List<Integer> candidate, int[] nums)
    {
        ans.add(new ArrayList<>(candidate));
        for(int i=current; i<nums.length; i++)
        {
            candidate.add(nums[i]);
            generate(i+1, candidate, nums);
            candidate.remove(candidate.size() - 1);
        }
    }
}