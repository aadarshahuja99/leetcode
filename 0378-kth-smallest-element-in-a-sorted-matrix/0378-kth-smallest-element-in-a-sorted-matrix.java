class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return a[0]-b[0];
        });
        int n = matrix.length;
        for(int i=0; i<n; i++)
        {
            minHeap.add(new int[] { matrix[i][0], i, 0 });
        }
        while(k-- > 1)
        {
            int[] top = minHeap.poll();
            int rowIndex = top[1];
            int colIndex = top[2];
            if(colIndex+1 < n)
            {
                minHeap.add(new int[] { matrix[rowIndex][colIndex+1], rowIndex, colIndex+1 });
            }
        }
        return minHeap.peek()[0];
    }
}