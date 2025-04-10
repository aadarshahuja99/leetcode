class Solution {
    int[] deltaR = { 1,0,-1,0 };
    int[] deltaC = { 0,1,0,-1 };
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        var positions = find(board,start);
        if(positions.size() == 0)
        {
            return false;
        }
        if(word.length() == 1)
        {
            return true;
        }
        int[][] visited = new int[board.length][board[0].length];
        for(int[] p : positions)
        {
            if(dfs(p[0],p[1],1,word,board,visited))
            {
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int row, int col, int current, String word, char[][] board, int[][] visited)
    {
        if(current == word.length())
        {
            return true;
        }
        visited[row][col] = 1;
        for(int i=0; i<4; i++)
        {
            int nR = row + deltaR[i];
            int nC = col + deltaC[i];
            if(nR >=0 && nR<board.length && nC>=0 && nC <board[0].length && board[nR][nC] == word.charAt(current) && visited[nR][nC] == 0)
            {
                if(dfs(nR,nC,current+1,word,board,visited))
                {
                    return true;
                }
            }
        }
        visited[row][col] = 0;
        return false;
    }
    private ArrayList<int[]> find(char[][] board, char start)
    {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j] == start)
                {
                    list.add(new int[] { i, j });
                }
            }
        }
        return list;
    }
}