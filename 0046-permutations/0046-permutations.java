class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> permutations = new ArrayList<>();
        getAllPermutations(0, (1<<(nums.length))-1, nums, permutations, new LinkedList<Integer>());
        return permutations;
    }
    private void getAllPermutations(int currentIndex, int availabilityMask, int[] nums, ArrayList<List<Integer>> permutations, LinkedList<Integer> currentList)
    {
        if(currentIndex == nums.length)
        {
            if(availabilityMask == 0)
            {
                ArrayList<Integer> current = new ArrayList<>(currentList);
                permutations.add(current);
            }
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if((availabilityMask&(1<<i)) > 0)
            {
                currentList.addLast(nums[i]);
                getAllPermutations(currentIndex+1, (availabilityMask^(1<<i)), nums, permutations, currentList);
                currentList.removeLast();
            }
        }
    }
}