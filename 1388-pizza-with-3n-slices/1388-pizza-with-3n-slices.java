class Solution {
    public int maxSizeSlices(int[] slices) {
        int[][] cache = new int[slices.length+1][slices.length/3 + 1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        int[][] cache2 = new int[slices.length+1][slices.length/3 + 1];
        for(int[] row : cache2)
        {
            Arrays.fill(row, -1);
        }
        return Math.max(getAns(0, slices.length/3, slices, cache, slices.length - 2),
        getAns(1, slices.length/3, slices, cache2, slices.length - 1));
    }
    private int getAns(int current, int count, int[] slices, int[][] cache, int last)
    {
        if(count == 0 || current > last)
        {
            return 0;
        }
        if(cache[current][count] != -1)
        {
            return cache[current][count];
        }
        return cache[current][count] = Math.max(getAns(current+1, count, slices, cache, last),
        slices[current] + getAns(current+2, count-1, slices, cache, last));
    }
}