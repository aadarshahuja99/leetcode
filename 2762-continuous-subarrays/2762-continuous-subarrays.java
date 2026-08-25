class Solution {
    public long continuousSubarrays(int[] nums) {
        // Same logic and question as: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?envType=problem-list-v2&envId=monotonic-queue , only diff is hardcoded threshold limit of 2 instead of input param and counting the subarrays instead of finding max length
        int n = nums.length;
        int s = 0;
        int e = 0;
        long ans = 0;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        while(e < n)
        {
            // consume 'e'
            while(max.size() > 0 && max.peekLast() < nums[e])
            {
                max.removeLast();
            }
            max.add(nums[e]);

            while(min.size() > 0 && min.peekLast() > nums[e])
            {
                min.removeLast();
            }
            min.add(nums[e]);
            e++;

            while(max.peekFirst() - min.peekFirst() > 2)
            {
                int element = nums[s];
                if(max.peekFirst() == element)
                {
                    max.poll();
                }

                if(min.peekFirst() == element)
                {
                    min.poll();
                }
                s++;
            }
            ans += (e - s);
        }
        return ans;
    }
}