class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] cache = new int[n][n];
        int ans = 0;
        for(int i=2; i<n; i++)
        {
            for(int j=0, k=i-1; j<k;)
            {
                if(arr[j] + arr[k] == arr[i])
                {
                    int current = Math.max(3, cache[k][j] + 1);
                    cache[i][k] = Math.max(current, cache[i][k]);
                    ans = Math.max(ans, cache[i][k]);
                    k--;
                    j++;
                }
                else if(arr[j] + arr[k] < arr[i])
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return ans;
    }
}