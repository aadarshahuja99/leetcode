class Solution {
    public int minimumEffortPath(int[][] heights) {
        if(heights.length == 1 && heights[0].length == 1)
        {
            return 0;
        }
        int[][] effort = new int[heights.length][heights[0].length];
        for(int[] effortRow : effort)
        {
            Arrays.fill(effortRow,Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        PriorityQueue<QueueElement> pq = new PriorityQueue<QueueElement>(new Comparator<QueueElement>() {
    public int compare(QueueElement n1, QueueElement n2) {
        return n1.getDistance() - n2.getDistance();
    }
});
        pq.add(new QueueElement(0,0,0));
        int ans = Integer.MAX_VALUE;
        while(pq.size() > 0)
        {
            QueueElement top = pq.poll();
            int row = top.getRow();
            int col = top.getCol();
            int dist = top.getDistance();
            int[] deltaRow = {1, 0, -1, 0};
            int[] deltaCol = {0, 1, 0, -1};
            for(int i=0;i<4;i++)
            {
                int newRow = row+deltaRow[i];
                int newCol = col+deltaCol[i];
                if(newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length)
                {
                    // this is to compute the max effort on the current path
                    int newEffort = Math.max(Math.abs(heights[newRow][newCol] - heights[row][col]), dist);
                    // this if block ensures that the globally min effort value is stored in each cell
                    if(newEffort < effort[newRow][newCol])
                    {
                        effort[newRow][newCol] = newEffort;
                        pq.add(new QueueElement(newRow,newCol,effort[newRow][newCol]));
                    }
                }
            }
        }
        return effort[heights.length-1][heights[0].length-1];
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