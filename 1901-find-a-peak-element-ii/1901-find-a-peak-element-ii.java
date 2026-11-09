class Solution {
    public int[] findPeakGrid(int[][] mat) {
        if(mat.length == 1 && mat[0].length == 1)
        {
            return new int[] { 0,0 };
        }
        if(mat.length == 1)
        {
            int max = Integer.MIN_VALUE;
            int ansC = 0;
            for(int it = 0; it < mat[0].length; it++)
            {
                if(max < mat[0][it])
                {
                    max = mat[0][it];
                    ansC = it;
                }
            }
            return new int[] { 0,ansC };
        }
        if(mat[0].length == 1)
        {
            int max = Integer.MIN_VALUE;
            int ansR = 0;
            for(int it = 0; it < mat.length; it++)
            {
                if(max < mat[it][0])
                {
                    max = mat[it][0];
                    ansR = it;
                }
            }
            return new int[] { ansR,0 };
        }
        int start = 0;
        int end = mat[0].length-1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            int currentRow = getMax(mat,mid);
            int[] deltaC = { 1,-1 };
            int currentCol = mid;
            int breakingCol = -1;
            for(int i=0; i<2; i++)
            {
                int newCol = currentCol + deltaC[i];
                if(newCol < mat[0].length && newCol >= 0 && mat[currentRow][newCol] > mat[currentRow][currentCol])
                {
                    breakingCol = newCol;
                    break;
                }
            }
            // System.out.println(breakingCol+" for "+currentRow+", "+currentCol);
            if(breakingCol == -1)
            {
                return new int[] { currentRow,currentCol };
            }
            if(breakingCol < currentCol)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return new int[] { -1,-1 };
    }
    private int getMax(int[][] mat, int col)
    {
        int max = Integer.MIN_VALUE;
        int row = -1;
        for(int it = 0; it < mat.length; it++)
        {
            if(max < mat[it][col])
            {
                row = it;
                max = mat[it][col];
            }
        }
        return row;
    }
}