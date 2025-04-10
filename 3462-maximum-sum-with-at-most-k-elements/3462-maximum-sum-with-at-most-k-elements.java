class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            return b[1] - a[1];
        });
        int r = grid.length;
        int c = grid[0].length;
        for(int[] row : grid)
        {
            Arrays.sort(row);
        }
        int[] pointers = new int[r];
        Arrays.fill(pointers, c-1);
        for(int i=0; i<r; i++)
        {
            if(c - limits[i] - 1 < pointers[i])
            {
                maxHeap.add(new int[] { i, grid[i][pointers[i]] });
                pointers[i]--;
            }
        }
        long ans = 0l;
        while(k > 0)
        {
            var top = maxHeap.poll();
            ans += top[1];
            int row = top[0];
            if(pointers[row] > c - limits[row] - 1)
            {
                maxHeap.add(new int[] { row, grid[row][pointers[row]] });
                pointers[row]--;
            }
            k--;
        }
        return ans;
    }
}