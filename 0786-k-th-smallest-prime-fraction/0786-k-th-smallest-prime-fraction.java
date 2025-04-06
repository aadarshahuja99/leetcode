class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return Double.compare(1.0*arr[a[0]]/arr[a[1]], 1.0*arr[b[0]]/arr[b[1]]);
            }
        });
        for(int i=0; i<n-1; i++)
        {
            pq.add(new int[] { i,n-1 });
        }
        while(k-- > 1)
        {
            int[] top = pq.poll();
            int numeratorIndex = top[0];
            int denomenatorIndex = top[1];
            denomenatorIndex--;
            if(denomenatorIndex > numeratorIndex)
            {
                pq.add(new int[] { numeratorIndex, denomenatorIndex });
            }
        }
        return new int[] { arr[pq.peek()[0]], arr[pq.peek()[1]] };
    }
}