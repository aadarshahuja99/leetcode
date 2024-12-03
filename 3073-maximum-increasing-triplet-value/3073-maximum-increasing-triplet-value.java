class Solution {
    public int maximumTripletValue(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> pre = new TreeSet<>();
        TreeSet<Integer> post = new TreeSet<>();
        pre.add(nums[0]);
        post.add(nums[n-1]);
        int[] before = new int[n];
        for(int i=1; i<n; i++)
        {
            var current = pre.floor(nums[i] - 1);
            if(current == null)
            {
                before[i] = Integer.MAX_VALUE;
            }
            else
            {
                before[i] = current;
            }
            pre.add(nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=n-2; i>=1; i--)
        {
            int current = post.last();
            // System.out.println(current+" "+before[i]+" for i = "+nums[i]);
            if(current <= nums[i] || before[i] == Integer.MAX_VALUE)
            {
                post.add(nums[i]);
                continue;
            }
            ans = Math.max(ans, before[i] - nums[i] + current);
            post.add(nums[i]);
        }
        return ans;
    }
}