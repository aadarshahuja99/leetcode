class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> subsets = new ArrayList<>();
        createSubsets(0, nums, subsets, new LinkedList<Integer>());
        return subsets;
    }
    private void createSubsets(int currentIndex, int[] nums, ArrayList<List<Integer>> subsets, LinkedList<Integer> currentSubset)
    {
        subsets.add(new ArrayList<Integer>(currentSubset));
        for(int i=currentIndex; i<nums.length; i++)
        {
            if(i != currentIndex && nums[i-1] == nums[i])
            {
                continue;
            }
            currentSubset.addLast(nums[i]);
            createSubsets(i+1, nums, subsets, currentSubset);
            currentSubset.removeLast();
        }
    }
}