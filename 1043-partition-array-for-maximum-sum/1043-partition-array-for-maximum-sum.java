class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] cache = new int[arr.length];
        Arrays.fill(cache, -1);
        return getAns(0, arr, k, cache);
    }
    private int getAns(int curr, int[] arr, int k, int[] cache)
    {
        if(curr == arr.length)
        {
            return 0;
        }
        if(cache[curr] != -1)
        {
            return cache[curr];
        }
        int maxVal = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=curr; i<Math.min(arr.length,curr+k); i++)
        {
            maxVal = Math.max(maxVal, arr[i]);
            ans = Math.max(ans, (i-curr+1)*maxVal + getAns(i+1, arr, k, cache));
        }
        return cache[curr] = ans;
    }
}