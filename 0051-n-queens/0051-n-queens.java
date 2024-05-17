class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        // ArrayList<List<Integer>> intermediateResult = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board)
        {
            Arrays.fill(row, '.');
        }
        solve(0, 0, board, result, n);
        return result;
    }
    private void solve(int currentRow, int columnStatus, char[][] board, ArrayList<List<String>> finalAns, int n)
    {
        if(currentRow == n)
        {
            updateAns(board, finalAns, n);
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
            for(int r=currentRow, c=i; r<n && c>=0; r++, c--)
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
            solve(currentRow + 1, columnStatus|(1<<i), board, finalAns, n);
            board[currentRow][i] = '.';
        }
    }

    private void updateAns(char[][] board, ArrayList<List<String>> finalAns, int n)
    {
        List<String> currentAns = new ArrayList<String>();
        for(int i=0; i<n; i++)
        {
            currentAns.add(new String(board[i]));
        }
        finalAns.add(currentAns);
    }
}