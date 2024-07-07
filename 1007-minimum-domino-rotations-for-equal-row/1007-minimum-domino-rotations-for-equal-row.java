class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min = tops.length+1;
        int[][][] cache = new int[tops.length][7][2];
        for(int[][] outer : cache)
        {
            for(int[] row : outer)
            {
                Arrays.fill(row, -1);
            }
        }
        for(int i=1; i<=6; i++)
        {
            for(int face=0; face<=1; face++)
            {
                min = Math.min(min, getAns(0, i, face, tops, bottoms, cache));
            }
        }
        return min > tops.length ? -1 : min;
    }
    private int getAns(int current, int desiredVal, int desiredRow, int[] tops, int[] bottoms, int[][][] cache)
    {
        if(current == tops.length)
        {
            return 0;
        }
        if(cache[current][desiredVal][desiredRow] != -1)
        {
            return cache[current][desiredVal][desiredRow];
        }
        if(tops[current] != desiredVal && bottoms[current] != desiredVal)
        {
            return cache[current][desiredVal][desiredRow] = tops.length+1;
        }
        if(tops[current] == desiredVal && bottoms[current] == desiredVal)
        {
            return cache[current][desiredVal][desiredRow] = getAns(current+1, desiredVal, desiredRow, tops, bottoms, cache);
        }
        if((tops[current] == desiredVal && desiredRow == 1) || (bottoms[current] == desiredVal && desiredRow == 0))
        {
            return cache[current][desiredVal][desiredRow] = 1 + getAns(current+1, desiredVal, desiredRow, tops, bottoms, cache);
        }
        return cache[current][desiredVal][desiredRow] = getAns(current+1, desiredVal, desiredRow, tops, bottoms, cache);
    }
}