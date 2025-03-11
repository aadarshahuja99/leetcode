class Solution {
    int MOD = 1_000_000_007;
    // same question as max subsequence score
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] combined = new int[n][2];
        for(int i=0; i<n; i++)
        {
            combined[i] = new int[] { speed[i], efficiency[i] };
        }
        Arrays.sort(combined, (a,b) -> {
            return b[1] - a[1];
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        int idx = 0;
        for(int[] eng : combined)
        {
            if(minHeap.size() == k)
            {
                sum -= minHeap.poll();
            }
            sum += (eng[0]);
            minHeap.add(eng[0]);
            // System.out.println("sum = "+sum+" at idx = "+idx+" and eff: "+eng[1]);
            ans = Math.max(ans, (sum*eng[1]));
            idx++;
        }
        return (int)(ans%MOD);
    }
}