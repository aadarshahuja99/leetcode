class Solution {
    public int minMoves(int[] nums, int limit) {
        // 3 cases for each pair:
        // targetSum = currentSum -> no changes
        // targetSum >= 2 and targetSum < min(A,B) + 1 -> change the max and min both
        // targetSum >= min(A,B) + 1 and targetSum <= max(A,B) + limit -> update only the min one of A and B
        // targetSum > max(A,B) + limit and targetSum <= 2*limit -> update both
        int[] counts = new int[2*limit + 2];
        int[] changes = new int[2*limit + 2];
        int n = nums.length;
        int pairs = n/2;
        for(int i=0; i<n/2; i++)
        {
            int other = n-i-1;
            int min = Math.min(nums[other], nums[i]);
            changes[min+1]++;
            changes[Math.max(nums[other], nums[i]) + limit + 1]--;
            counts[nums[other] + nums[i]]++;
        }
        // for(int i=0; i<counts.length; i++)
        // {
        //     System.out.println(i+" "+counts[i]);
        // }
        int totalChanges = 0;
        int ans = n;
        for(int current=2; current <= 2*limit; current++)
        {
            totalChanges += changes[current];
            // System.out.println(counts[current]+", "+totalChanges+" for "+current);
            ans = Math.min(totalChanges + 2*(n/2 - totalChanges) - counts[current], ans);
        }
        return ans;
    }
}