class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] min = new int[arr.length];
        int[] max = new int[arr.length];
        int currentMax = arr[0];
        int currentMin = arr[arr.length-1];
        min[arr.length-1] = arr[arr.length-1];
        max[0] = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            currentMax = Math.max(currentMax, arr[i]);
            max[i] = currentMax;
        }
        min[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--)
        {
            currentMin = Math.min(currentMin, arr[i]);
            min[i] = currentMin;
        }
        int count = 0;
        for(int i=1; i<arr.length; i++)
        {
            if(max[i-1] <= min[i])
            {
                count++;
            }
        }
        return count+1;
    }
}