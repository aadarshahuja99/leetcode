class Solution {
    public int countBattleships(char[][] board) {
        // One scan without dfs/bfs or extra space
        // intuition: increment the answer/count only if the current 'X' cell does not have a X on top or on the left
        int ans = 0;
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(board[i][j] == 'X' && (i == 0 || (i > 0 && board[i-1][j] != 'X')) && (j == 0 || (board[i][j-1] != 'X')))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}