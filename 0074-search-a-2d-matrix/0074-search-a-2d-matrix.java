class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // get r,c coordinate from index + BS
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0;
        int e = m*n-1;
        while(s <= e)
        {
            int mid = s + (e-s)/2;
            int[] coordinates = getCoordinates(mid,n);
            int r = coordinates[0];
            int c = coordinates[1];
            if(matrix[r][c] == target)
            {
                return true;
            }
            else if(matrix[r][c] < target)
            {
                s = mid + 1;
            }
            else
            {
                e = mid - 1;
            }
        }
        return false;
    }
    private int[] getCoordinates(int idx, int n)
    {
        return new int[] { idx/n, idx%n };
    }
}