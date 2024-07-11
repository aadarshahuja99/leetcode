class Solution {
    static int arr[][];
    static int n;
    static int m;

    static boolean dfs(int r, int c){
        if(r+1==n && c+1==m) return true;
        if(r>=n || c>=m || arr[r][c]==0) return false;

        arr[r][c] = 0;
        return dfs(r+1,c) || dfs(r,c+1);
    }
    public boolean isPossibleToCutPath(int[][] grid) {
        arr = grid;
        n = arr.length;
        m = arr[0].length;

        if(dfs(0,0)==false) return true;
        arr[0][0] = 1;
        return !dfs(0,0);
    }
}