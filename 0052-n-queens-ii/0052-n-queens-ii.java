class Solution {
    public int totalNQueens(int n) {
        int[] ans = new int[1];
        char[][] board = new char[n][n];
        for(char[] row : board)
        {
            Arrays.fill(row, '.');
        }
        solve(0, 0, board, ans, n);
        return ans[0];
    }
    private void solve(int currentRow, int columnStatus, char[][] board, int[] ans, int n)
    {
        if(currentRow == n)
        {
            ans[0]++;
            return;
        }
        for(int i=0; i<n; i++)
        {
            if((columnStatus&(1<<i)) > 0)
            {
                continue;
            }
            boolean isValid = true;
            for(int r=currentRow, c=i; r>=0 && c>=0; r--, c--)
            {
                if(board[r][c] == 'Q')
                {
                    isValid = false;
                    break;
                }
            }
            for(int r=currentRow, c=i; r>=0 && c<n; r--, c++)
            {
                if(board[r][c] == 'Q')
                {
                    isValid = false;
                    break;
                }
            }
            if(!isValid)
            {
                continue;
            }
            board[currentRow][i] = 'Q';
            solve(currentRow + 1, columnStatus|(1<<i), board, ans, n);
            board[currentRow][i] = '.';
        }
    }
}