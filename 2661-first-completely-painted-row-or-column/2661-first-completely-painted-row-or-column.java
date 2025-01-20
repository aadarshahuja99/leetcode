class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer,int[]> colors = new HashMap<>();
        int[] rowStatus = new int[m];
        int[] colStatus = new int[n];
        for(int i=0; i < m ;i++)
        {
            for(int j=0; j<n; j++)
            {
                colors.put(mat[i][j], new int[] { i, j });
            }
        }
        int idx = 0;
        for(int col : arr)
        {
            var pos = colors.get(col);
            rowStatus[pos[0]]++;
            colStatus[pos[1]]++;
            if(rowStatus[pos[0]] == n || colStatus[pos[1]] == m)
            {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}