class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0; // indicates that ith row must be set to 0
                    if(j == 0)
                    {
                        col0 = 0; // indicates that 0th column must be set to 0
                    }
                    else
                    {
                        matrix[0][j] = 0; // indicates that j-th column must be set to 0
                    }
                }
            }
        }
        // update the inner elements of the matrix on the basis of the 2 arrays that we have used in place for storing status
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(matrix[i][j] != 0 && (matrix[i][0] == 0) || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0)
        {
            // set all values in the first row as 0
            for(int j=0; j<n; j++)
            {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0)
        {
            // set all values in the first column as 0
            for(int i=0; i<m; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}