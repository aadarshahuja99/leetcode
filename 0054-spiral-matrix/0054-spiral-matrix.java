class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = m-1;
        int colStart = 0;
        int colEnd = n-1;
        HashSet<Integer> vis = new HashSet<>();
        while(rowStart <= rowEnd && colStart <= colEnd)
        {
            // System.out.println(rowStart+" "+rowEnd+" "+colStart+" "+colEnd);
            for(int i=colStart; i<=colEnd; i++)
            {
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;
            if(rowStart > rowEnd)
            {
                break;
            }
            for(int i=rowStart; i<=rowEnd; i++)
            {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(colStart > colEnd)
            {
                break;
            }
            for(int i=colEnd; i>=colStart; i--)
            {
                ans.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if(rowStart > rowEnd)
            {
                break;
            }
            for(int i=rowEnd; i>=rowStart; i--)
            {
                ans.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return ans;
    }
    private int getKey(int r, int c, int n)
    {
        return r*n + c;
    }
}