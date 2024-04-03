class Solution {
    public int snakesAndLadders(int[][] board) {
        // do not over-complicate your answers.
        // approach: apply BFS from (n-1,0) to  (0,0). 0-1 BFS will be sufficient. Also, the same node should not be visited twice. If I have already reach 13 from 17 at an earlier timestamp, then there is no need for adding 13 to the queue again for BFS
        Queue<int[]> queue = new LinkedList<>();
        int startRow = board.length-1;
        int startColumn = 0;
        queue.add(new int[] { 1, 0 });
        int n = board.length;
        int[] visited = new int[n*n];
        while(queue.size() > 0)
        {
            var top = queue.poll();
            int value = top[0];
            int moves = top[1];
            for(int next = 1; next <= 6; next++)
            {
                int nextValue = value + next;
                int[] position = getPositionByValue(nextValue, n);
                int row = position[0];
                int col = position[1];
                if(board[row][col] != -1)
                {
                    nextValue = board[row][col];
                }
                if(nextValue > n*n || visited[nextValue-1] == 1)
                {
                    continue;
                }
                if(nextValue == n*n)
                {
                    return moves+1;
                }
                visited[nextValue-1] = 1;
                queue.add(new int[] { nextValue, moves+1 });
            }
        }
        return -1;
    }
    private int[] getPositionByValue(int value, int n)
    {
        if(((value - 1)/n)%2 == 0)
        {
            return new int[] { n-1 - ((value-1)/n), (value-1)%n };
        }
        return new int[] { n-1 - ((value-1)/n), (n-1) - (value-1)%n };
    }
}