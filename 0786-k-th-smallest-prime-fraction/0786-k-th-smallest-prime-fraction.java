class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return arr[a[0]]*arr[n-1-b[1]] - arr[b[0]]*arr[n-1-a[1]];
            }
        });
        for(int i=0; i<n; i++)
        {
            pq.add(new int[] { i,0 });
        }
        while(k-- > 1)
        {
            int[] top = pq.poll();
            int numeratorIndex = top[0];
            int denomenatorIndex = top[1];
            if(denomenatorIndex+1 < n)
            {
                pq.add(new int[] { numeratorIndex, denomenatorIndex+1 });
            }
        }
        return new int[] { arr[pq.peek()[0]], arr[arr.length - 1 - pq.peek()[1]] };
    }
}