class Solution {
    final int MOD = 1_000_000_007;
    int[][] DIRS = {{0,-1}, {-1,0}, {-1,-1}};
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        Element[][] dp1 = new Element[n][n];
        Element score = getAns(n-1, n-1, n, board, dp1);
        return new int[] { score.max, score.count };
    }
    private Element getAns(int row, int col, int size, List<String> board, Element[][] dp)
    {
        if(row == 0 && col == 0)
        {
            return new Element(1, 0);
        }
        if(dp[row][col] != null)
        {
            return dp[row][col];
        }
        int currentVal = board.get(row).charAt(col) == 'S' ? 0 : board.get(row).charAt(col) - '0';
        Element e = new Element();
        for(int[] DIR : DIRS)
        {
            int nr = row + DIR[0];
            int nc = col + DIR[1];
            if(nr < 0 || nc < 0 || board.get(nr).charAt(nc) == 'X')
            {
                continue;
            }
            Element ans = getAns(nr, nc, size, board, dp);
            if(ans.max > e.max)
            {
                e.count = ans.count;
                e.max = ans.max;
            }
            else if(ans.max == e.max)
            {
                e.count = (e.count%MOD + ans.count%MOD)%MOD;
                e.max = ans.max;
            }
        }
        if(e.count > 0)
        {
            e.max += currentVal;
        }
        return dp[row][col] = e;
    }
    class Element
    {
        public int count;
        public int max;
        public Element()
        {}
        public Element(int c, int m)
        {
            count = c;
            max = m;
        }
    }
}