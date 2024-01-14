class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1)
        {
            return -1;
        }
        LinkedList<QueueElement> q = new LinkedList<QueueElement>();
        q.addLast(new QueueElement(0,0,1));
        int[][] visited = new int[grid.length][grid.length];
        visited[0][0] = 1;
        while(q.size() > 0)
        {
            QueueElement top = q.removeFirst();
            int row = top.getRow();
            int col = top.getCol();
            int dist = top.getDistance();
            if(row == grid.length-1 && col == grid.length - 1)
            {
                return dist;
            }
            int[] deltaRow = {1, 1, -1, -1, 1, 0, -1, 0};
            int[] deltaCol = {-1, 1, -1, 1, 0, 1, 0, -1};
            for(int i=0;i<8;i++)
            {
                int newRow = row+deltaRow[i];
                int newCol = col+deltaCol[i];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 0)
                {
                    visited[newRow][newCol] = 1;
                    q.addLast(new QueueElement(newRow,newCol,dist+1));
                }
            }
        }
        return -1;
    }
    class QueueElement
    {
        private int row;
        private int col;
        private int dist;
        public QueueElement(int r, int c, int d)
        {
            row = r;
            col = c;
            dist = d;
        }
        public void setDistance(int d)
        {
            dist = d;
        }
        public int getDistance()
        {
            return dist;
        }
        public int getRow()
        {
            return row;
        }
        public int getCol()
        {
            return col;
        }
    }
}