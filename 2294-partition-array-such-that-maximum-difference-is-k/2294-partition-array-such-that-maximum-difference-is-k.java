class Solution {
    public int partitionArray(int[] nums, int k) {
        // nlogn using sorting and one traversal. Can be optimized to o(n) using extra space of o(n) using the idea of buckets
        // NOTE: a subsequence is a subsequence, the order in which elements of a subsequence are selected do not matter
        Arrays.sort(nums);
        int i=0;
        int n=nums.length;
        int ans = 0;
        while(i < n)
        {
            int j = i;
            while(j < n && nums[j] - nums[i] <= k)
            {
                j++;
            }
            ans++;
            i = j;
        }
        return ans;
    }
}