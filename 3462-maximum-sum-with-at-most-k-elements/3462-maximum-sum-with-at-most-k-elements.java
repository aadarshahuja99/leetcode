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
            for(int i=0; i<c/2; i++)
            {
                int temp = row[i];
                row[i] = row[c-i-1];
                row[c-i-1] = temp;
            }
        }
        int[] pointers = new int[r];
        for(int i=0; i<r; i++)
        {
            if(limits[i] > pointers[i])
            {
                maxHeap.add(new int[] { i, grid[i][pointers[i]] });
                pointers[i]++;
            }
        }
        if(maxHeap.size() == 0)
        {
            return 0;
        }
        long ans = 0l;
        while(k > 0)
        {
            var top = maxHeap.poll();
            ans += top[1];
            int row = top[0];
            if(pointers[row] < limits[row])
            {
                maxHeap.add(new int[] { row, grid[row][pointers[row]] });
                pointers[row]++;
            }
            k--;
        }
        return ans;
    }
}