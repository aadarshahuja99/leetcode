class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // brute-force. Worst case: (n2)log(n2)
            // if(matrix.length == 1 || k == 1)
            // {
            //     return matrix[0][0];
            // }
            // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            // for(int[] row : matrix)
            // {
            //     for(int element : row)
            //     {
            //         pq.add(element);
            //         if(pq.size() > k)
            //         {
            //             pq.poll();
            //         }
            //     }
            // }
            // return pq.peek();
        // more efficient solution (inspired from k sorted arrays problem):
        // if matrix[i][j] is taken as the next smallest element, add matrix[i][j+1] to the pq. The complexity for this approach is: O(klogN)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] element1, int[] element2)
            {
                return element1[0] - element2[0];
            }
        });
        int n = matrix.length;
        for(int i=0; i<n; i++)
        {
            pq.add(new int[] { matrix[i][0], i, 0 });
        }
        while(k > 1)
        {
            int[] top = pq.poll();
            int row = top[1];
            int column = top[2];
            if(column < n-1)
            {
                pq.add(new int[] { matrix[row][column+1], row, column+1 });
            }
            k--;
        }
        return pq.peek()[0];
    }
}