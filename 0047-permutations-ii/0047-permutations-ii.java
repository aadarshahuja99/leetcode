class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> permutations = new ArrayList<>();
        getAllUniquePermutations(0,(int)Math.pow(2,nums.length)-1, nums, permutations, new LinkedList<Integer>());
        return permutations;
    }
    private void getAllUniquePermutations(int currentIndex, int statusMask, int[] nums, ArrayList<List<Integer>> permutations, LinkedList<Integer> currentList)
    {
        if(currentIndex == nums.length)
        {
            permutations.add(new ArrayList<>(currentList));
            return;
        }
        int n = nums.length;
        HashSet<Integer> visitedNumbersForCurrentChoice = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            if((statusMask&(1<<i)) > 0 && !visitedNumbersForCurrentChoice.contains(nums[i]))
            {
                visitedNumbersForCurrentChoice.add(nums[i]);
                currentList.addLast(nums[i]);
                getAllUniquePermutations(currentIndex+1, statusMask^(1<<i), nums, permutations, currentList);
                currentList.removeLast();
            }
        }
    }
}