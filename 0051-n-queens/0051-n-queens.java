class Solution {
    ArrayList<List<String>> finalAns;
    public List<List<String>> solveNQueens(int n) {
        finalAns = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board)
        {
            Arrays.fill(row, '.');
        }
        solve(0, 0, board, n);
        return finalAns;
    }
    private void solve(int currentRow, int columnStatus, char[][] board, int n)
    {
        if(currentRow == n)
        {
            // if all the queens are placed in the board then add it to the list of answers
            updateAns(board, finalAns, n);
            return;
        }
        for(int i=0; i<n; i++)
        {
            if((columnStatus&(1<<i)) > 0)
            {
                // only consider a column if it has not been taken so far
                continue;
            }
            boolean isValid = true;
            // check for diagonal attacks from 2 directions
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
            solve(currentRow + 1, columnStatus|(1<<i), board, n); // take the current row, column for a queen if it is valid
            board[currentRow][i] = '.'; // back-track
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