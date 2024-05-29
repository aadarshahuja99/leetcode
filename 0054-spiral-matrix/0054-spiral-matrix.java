class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        if(m == 1 && n == 1)
        {
            ans.add(matrix[0][0]);
            return ans;
        }
        if(m == 1)
        {
            int i=0;
            int j=n-1;
            while(i <= n-1)
            {
                ans.add(matrix[0][i]);
                i++;
            }
            return ans;
        }
        if(n == 1)
        {
            int i=0;
            while(i <= m-1)
            {
                ans.add(matrix[i][0]);
                i++;
            }
            return ans;
        }
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
                int k = getKey(rowStart, i, n);
                if(!vis.contains(k))
                {
                    vis.add(k);
                    ans.add(matrix[rowStart][i]);
                }
            }
            for(int i=rowStart+1; i<=rowEnd; i++)
            {
                int k = getKey(i, colEnd, n);
                if(!vis.contains(k))
                {
                    vis.add(k);
                    ans.add(matrix[i][colEnd]);
                }
            }
            for(int i=colEnd-1; i>=colStart; i--)
            {
                int k = getKey(rowEnd, i, n);
                if(!vis.contains(k))
                {
                    vis.add(k);
                    ans.add(matrix[rowEnd][i]);
                }
            }
            for(int i=rowEnd-1; i>=rowStart+1; i--)
            {
                int k = getKey(i, colStart, n);
                if(!vis.contains(k))
                {
                    vis.add(k);
                    ans.add(matrix[i][colStart]);
                }
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return ans;
    }
    private int getKey(int r, int c, int n)
    {
        return r*n + c;
    }
}