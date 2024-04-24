class Solution {
    public int maximumJumps(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(Math.abs(nums[j] - nums[i]) <= target)
                {
                    adjList.get(i).add(j);
                }
            }
        }
        int[] cache = new int[n];
        Arrays.fill(cache, -1002);
        int ans = getMaxJumps(0, n, adjList, cache);
        ans = ans < 0 ? -1 : ans;
        return ans;
    }
    private int getMaxJumps(int current, int n, ArrayList<ArrayList<Integer>> adjList, int[] cache)
    {
        if(current == n-1)
        {
            return 0;
        }
        if(cache[current] != -1002)
        {
            return cache[current];
        }
        int ans = -1001;
        for(int adjacent : adjList.get(current))
        {
            ans = Math.max(ans, 1 + getMaxJumps(adjacent, n, adjList, cache));
        }
        return cache[current] = ans;
    }
}