class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // use hash array (commonly called as buckets) to store the count of each element while traversing the nums array from right to left
        int n = nums.length;
        int treeSize = 2*10000 + 2; // -10000, 10000 is the range for nums[i] and +1 is added for dummy node of BIT
        int[] BIT = new int[treeSize];
        int[] hash = new int[treeSize-1];
        List<Integer> ans = new ArrayList<>(Collections.nCopies(nums.length, 0));
        for(int i=n-1; i>=0; i--)
        {
            ans.set(i, getCount(nums[i] + 10000 - 1, BIT, treeSize));
            hash[nums[i] + 10000]++;
            update(nums[i] + 10000, BIT, treeSize);
        }
        return ans;
    }

    private int getCount(int num, int[] tree, int treeSize)
    {
        num++;
        int count = 0;
        while(num >= 1)
        {
            count += tree[num];
            num -= (num&(-num));
        }
        return count;
    }

    private void update(int num, int[] tree, int treeSize)
    {
        num++;
        while(num < treeSize)
        {
            tree[num] += 1;
            num += (num&(-num));
        }
    }
}