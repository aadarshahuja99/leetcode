class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // O(m + n) solution by eliminating one row or column
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = n-1;
        while(r <= m-1 && c >= 0)
        {
            if(matrix[r][c] == target)
            {
                return true;
            }
            else if(matrix[r][c] < target)
            {
                r++;
            }
            else
            {
                c--;
            }
        }
        return false;
    }
}