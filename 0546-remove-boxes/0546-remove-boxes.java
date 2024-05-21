class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] cache = new int[n][n][n];
        for(int[][] outer : cache)
        {
            for(int[] row : outer)
            {
                Arrays.fill(row, -1);
            }
        }
        return getAns(0, n-1, 0, boxes, cache);
    }
    private int getAns(int start, int end, int boxesOfTheSameColorFromTheLeft, int[] boxes, int[][][] cache)
    {
        if(start > end)
        {
            return 0;
        }
        if(cache[start][end][boxesOfTheSameColorFromTheLeft] != -1)
        {
            return cache[start][end][boxesOfTheSameColorFromTheLeft];
        }
        int i=start;
        int temp = boxesOfTheSameColorFromTheLeft;
        while(i <= end && boxes[i] == boxes[start])
        {
            boxesOfTheSameColorFromTheLeft++;
            i++;
        }
        int remove = boxesOfTheSameColorFromTheLeft*boxesOfTheSameColorFromTheLeft + getAns(i, end, 0, boxes, cache);
        int max = remove;
        for(int it=i; it<=end; it++)
        {
            if(boxes[it] == boxes[i-1])
            {
                max = Math.max(max, getAns(i, it-1, 0, boxes, cache) + getAns(it, end, boxesOfTheSameColorFromTheLeft, boxes, cache));
            }
        }
        return cache[start][end][temp] = max;
    }
}