class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxSoFar = new int[n];
        maxSoFar[0] = arr[0];
        for(int i=1; i<n; i++)
        {
            maxSoFar[i] = Math.max(maxSoFar[i-1], arr[i]);
        }
        int min = Integer.MAX_VALUE;
        int count = 1;
        for(int i=n-1; i>=1; i--)
        {
            min = Math.min(min, arr[i]);
            if(min > maxSoFar[i-1])
            {
                count++;
            }
        }
        return count;
    }
}