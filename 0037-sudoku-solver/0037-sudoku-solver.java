class Solution {
    int[] matrixMask;
    int rowMask[];
    int colMask[];
    public void solveSudoku(char[][] board) {
        matrixMask = new int[9];
        colMask = new int[9];
        rowMask = new int[9];
        Arrays.fill(rowMask, (int)Math.pow(2,9)-1);
        Arrays.fill(colMask, (int)Math.pow(2,9)-1);
        Arrays.fill(matrixMask, (int)Math.pow(2,9)-1);
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] != '.')
                {
                    int val = board[i][j] - '0';
                    int mask = ~(1<<(val-1));
                    rowMask[i] = rowMask[i]&mask;
                    colMask[j] = colMask[j]&mask;
                    int matrix = getMatrix(i,j);
                    matrixMask[matrix] = (matrixMask[matrix]&mask);
                }
            }
        }
        // for(int m : rowMask)
        // {
        //     System.out.println("row: "+m);
        // }
        // for(int m : colMask)
        // {
        //     System.out.println("col: "+m);
        // }
        // System.out.println();
        // for(int m : matrixMask)
        // {
        //     System.out.println("mat: "+m);
        // }
        solve(0,0,board);
    }
    private boolean solve(int r, int c, char[][] board)
    {
        if(r == 9)
        {
            return true;
        }
        boolean ans = false;
        if(board[r][c] == '.')
        {
            for(int i=1; i<=9; i++)
            {
                int mask = (1<<(i-1));
                int matrix = getMatrix(r,c);
                if((rowMask[r]&mask) > 0 && (colMask[c]&mask) > 0 && (matrixMask[matrix]&mask) > 0)
                {
                    int unset = ~(1<<(i-1));
                    rowMask[r] = rowMask[r]&unset;
                    colMask[c] = colMask[c]&unset;
                    matrixMask[matrix] = matrixMask[matrix]&unset;
                    board[r][c] = (char)(i+'0');
                    if(c+1 == 9)
                    {
                        ans = ans || solve(r+1,0,board);
                    }
                    else
                    {
                        ans = ans || solve(r,c+1,board);
                    }
                    if(ans)
                    {
                        return true;
                    }
                    // reverting the changes
                    rowMask[r] = rowMask[r]|mask;
                    colMask[c] = colMask[c]|mask;
                    matrixMask[matrix] = matrixMask[matrix]|mask;
                    board[r][c] = '.';
                }
            }
        }
        else
        {
            if(c+1 == 9)
            {
                ans = ans || solve(r+1,0,board);
            }
            else
            {
                ans = ans || solve(r,c+1,board);
            }
            if(ans)
            {
                return true;
            }
        }
        return ans;
    }
    private int getMatrix(int r, int c)
    {
        if(r >=0 && r<=2 && c >= 0 && c <= 2)
        {
            return 0;
        }
        if(r >=3 && r <= 5 && c >= 0 && c <= 2)
        {
            return 1;
        }
        if(r >= 6 && r <= 8 && c >= 0 && c <= 2)
        {
            return 2;
        }
        if(r >= 0 && r <= 2 && c >= 3 && c <= 5)
        {
            return 3;
        }
        if(r >= 3 && r <= 5 && c >= 3 && c <= 5)
        {
            return 4;
        }
        if(r >= 6 && r <= 8 && c >= 3 && c <= 5)
        {
            return 5;
        }
        if(r >= 0 && r <= 2 && c >= 6 && c <= 8)
        {
            return 6;
        }
        if(r >= 3 && r <= 5 && c >= 6 && c <= 8)
        {
            return 7;
        }
        return 8;
    }
}