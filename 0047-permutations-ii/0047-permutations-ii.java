class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> permutations = new ArrayList<>();
        getAllUniquePermutations(0,(int)Math.pow(2,nums.length)-1, nums, permutations, new LinkedList<Integer>(), new HashSet<Integer>());
        return permutations;
    }
    private void getAllUniquePermutations(int currentIndex, int statusMask, int[] nums, ArrayList<List<Integer>> permutations, LinkedList<Integer> currentList, HashSet<Integer> visited)
    {
        if(currentIndex == nums.length)
        {
            if(!visited.contains(currentList.hashCode()))
            {
                ArrayList<Integer> current = new ArrayList<>(currentList);
                permutations.add(current);
                visited.add(currentList.hashCode());
            }
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if((statusMask&(1<<i)) > 0)
            {
                currentList.addLast(nums[i]);
                getAllUniquePermutations(currentIndex+1, statusMask^(1<<i), nums, permutations, currentList, visited);
                currentList.removeLast();
            }
        }
    }
}