class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] minBefore = new int[n];
        int[] minAfter = new int[n];
        for(int i=1; i<n; i++)
        {
            if(arr[i-1] < arr[i])
            {
                minBefore[i] = minBefore[i-1] + 1;
            }
        }
        for(int i=n-2; i>=0; i--)
        {
            if(arr[i+1] < arr[i])
            {
                minAfter[i] = minAfter[i+1] + 1;
            }
        }
        int maxMountain = 0;
        for(int i=1; i<=n-2; i++)
        {
            if(minBefore[i] > 0 && minAfter[i] > 0)
            {
                maxMountain = Math.max(maxMountain, minBefore[i] + minAfter[i] + 1);
            }
        }
        return maxMountain == 1 ? 0 : maxMountain;
    }
}