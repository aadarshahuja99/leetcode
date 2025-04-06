class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> subsets = new ArrayList<>();
        createSubsets(0, nums, subsets, new LinkedList<Integer>());
        return subsets;
    }
    private void createSubsets(int currentIndex, int[] nums, ArrayList<List<Integer>> subsets, LinkedList<Integer> currentSubset)
    {
        if(currentIndex == nums.length)
        {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }
        int i=currentIndex+1;
        while(i < nums.length && nums[i] == nums[currentIndex])
        {
            i++;
        }
        // dont take
        createSubsets(i, nums, subsets, currentSubset);
        // take
        currentSubset.addLast(nums[currentIndex]);
        createSubsets(currentIndex+1, nums, subsets, currentSubset);
        currentSubset.removeLast();
    }
}