class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] cache = new int[n][k];
        for(int[] row : cache)
        {
            Arrays.fill(row, 1);
        }
        int ans = 0;
        for(int i=1; i<n; i++)
        {
            int current = nums[i];
            for(int j=0; j<i; j++)
            {
                int last = nums[j];
                int mod = (current + last)%k;
                if(cache[j][mod] + 1 > cache[i][mod])
                {
                    cache[i][mod] = cache[j][mod] + 1;
                    // System.out.println("elem: " + current+" "+mod+" "+cache[i][mod]);
                }
                ans = Math.max(ans, cache[i][mod]);
            }
        }
        return ans;
    }
}