class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 1 || k == 1)
        {
            return matrix[0][0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] row : matrix)
        {
            for(int element : row)
            {
                pq.add(element);
                if(pq.size() > k)
                {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}