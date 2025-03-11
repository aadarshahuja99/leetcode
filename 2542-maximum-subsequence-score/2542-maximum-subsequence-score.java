class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long sum = 0;
        int n = nums1.length;
        int[][] combined = new int[n][3];
        for(int i=0; i<n; i++)
        {
            combined[i] = new int[] { nums1[i], nums2[i] };
        }
        Arrays.sort(combined, (a,b) -> {
            return b[1] - a[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++)
        {
            sum += combined[i][0];
            pq.add(combined[i][0]);
        }
        long ans = sum*combined[k-1][1];
        for(int i=k; i<n; i++)
        {
            sum += (combined[i][0] - pq.poll());
            ans = Math.max(ans, 1l*sum*combined[i][1]);
            pq.add(combined[i][0]);
        }
        return ans;
    }
}