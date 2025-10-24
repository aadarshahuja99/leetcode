class Solution {
    ArrayList<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        generate(0, new ArrayList<>(), nums);
        return ans;
    }
    private void generate(int current, List<Integer> candidate, int[] nums)
    {
        if(current == nums.length)
        {
            ans.add(new ArrayList<>(candidate));
            return;
        }
        // dont add current
        generate(current+1, candidate, nums);
        // add current
        candidate.add(nums[current]);
        generate(current+1, candidate, nums);
        candidate.remove(candidate.size() - 1); //back-track on the selection
    }
}
