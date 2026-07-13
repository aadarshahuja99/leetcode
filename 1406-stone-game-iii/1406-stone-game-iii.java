class Solution {
    public String stoneGameIII(int[] nums) {
        int[][] cache = new int[nums.length][2];
        for(int[] r : cache)
        {
            Arrays.fill(r, -1);
        }
        int diff = getAns(0, 1, nums, cache);
        return diff > 0 ? "Alice" : diff == 0 ? "Tie" : "Bob";
    }

    private int getAns(int current, int isAlice, int[] nums, int[][] cache) {
        int n = nums.length;
        if (current == n) {
            return 0;
        }
        
        // 1. Check cache before computing
        if (cache[current][isAlice] != -1) {
            return cache[current][isAlice];
        }
        int sum = 0;
        int ans = isAlice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for(int i=current; i<Math.min(current+3,n); i++)
        {
            sum += nums[i];
            if(isAlice == 1)
            {
                ans = Math.max(ans, sum + getAns(i+1, 0, nums, cache));
            }
            else
            {
                ans = Math.min(ans, -1*sum + getAns(i+1, 1, nums, cache));
            }
        }
        cache[current][isAlice] = ans;
        return ans;
    }
}
