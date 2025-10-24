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
        // this while loop ensures that we do not select the same number for the same position in the current candidate subset
        while(i < nums.length && nums[i] == nums[currentIndex])
        {
            i++;
        }
        // dont take all the remaining numbers with the same value
        createSubsets(i, nums, subsets, currentSubset);
        // take
        currentSubset.addLast(nums[currentIndex]);
        createSubsets(currentIndex+1, nums, subsets, currentSubset);
        currentSubset.removeLast();
    }
}