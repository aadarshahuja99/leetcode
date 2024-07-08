class Solution {
    public int minOperations(int[] nums) {
        Queue<Integer> flips = new LinkedList<>();
        int idx = 0;
        int ans = 0;
        int k=3;
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