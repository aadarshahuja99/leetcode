class Solution {
    public long continuousSubarrays(int[] nums) {
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

            while(max.peek() - min.peek() > 2)
            {
                int element = nums[s];
                if(max.peek() == element)
                {
                    max.poll();
                }

                if(min.peek() == element)
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