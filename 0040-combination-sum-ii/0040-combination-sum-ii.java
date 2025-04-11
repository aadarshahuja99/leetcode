class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        createSubsets(0, target, candidates, ans, new LinkedList<>());
        return ans;
    }
    private void createSubsets(int currentIndex, int rem, int[] nums, ArrayList<List<Integer>> subsets, LinkedList<Integer> currentSubset)
    {
        if(rem == 0)
        {
            subsets.add(new ArrayList<>(currentSubset));
        }
        if(currentIndex == nums.length)
        {
            return;
        }
        if(rem < nums[currentIndex])
        {
            return;
        }
        int i=currentIndex+1;
        while(i < nums.length && nums[i] == nums[currentIndex])
        {
            i++;
        }
        // dont take all the remaining numbers with the same value
        createSubsets(i, rem, nums, subsets, currentSubset);
        // take
        currentSubset.addLast(nums[currentIndex]);
        createSubsets(currentIndex+1, rem-nums[currentIndex], nums, subsets, currentSubset);
        currentSubset.removeLast();
    }
}