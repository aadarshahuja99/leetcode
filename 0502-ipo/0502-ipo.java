class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] combined = new int[n][2];
        for(int i=0; i<n; i++)
        {
            combined[i][0] = capital[i];
            combined[i][1] = profits[i];
        }
        Arrays.sort(combined, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int count = 0;
        int money = w;
        int idx = 0;
        while(count < k)
        {
            while(idx < n && combined[idx][0] <= money)
            {
                pq.add(combined[idx][1]);
                idx++;
            }
            if(pq.size() == 0)
            {
                return money;
            }
            money += pq.poll();
            count++;
        }
        return money;
    }
}