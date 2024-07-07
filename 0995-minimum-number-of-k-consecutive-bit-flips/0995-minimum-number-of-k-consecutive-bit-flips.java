class Solution {
    public int minKBitFlips(int[] nums, int k) {
        // use a queue to keep track of end indexes of flips
        Queue<Integer> flips = new LinkedList<>();
        int idx = 0;
        int ans = 0;
        for(int num : nums)
        {
            while(!flips.isEmpty() && flips.peek() < idx)
            {
                flips.poll();
            }
            int expectedValue = flips.size()%2 == 1 ? num == 1 ? 0 : 1 : num;
            if(expectedValue == 0)
            {
                if(idx+k-1 >= nums.length)
                {
                    return -1;
                }
                ans++;
                flips.add(idx+k-1);
            }
            idx++;
        }
        return ans;
    }
}