class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        boolean[] added = new boolean[n];
        PriorityQueue<Integer> pqStart = new PriorityQueue<>();
        PriorityQueue<Integer> pqEnd = new PriorityQueue<>();
        int hired = 0;
        int start = 0;
        int end = n-1;
        long ans = 0;
        while(hired < k)
        {
            while(pqStart.size() < candidates && start <= end)
            {
                pqStart.add(costs[start]);
                start++;
            }
            while(pqEnd.size() < candidates && end >= start)
            {
                pqEnd.add(costs[end]);
                end--;
            }
            int firstMin = pqStart.size() > 0 ? pqStart.peek() : Integer.MAX_VALUE;
            int secondMin = pqEnd.size() > 0 ? pqEnd.peek() : Integer.MAX_VALUE;
            if(firstMin <= secondMin)
            {
                ans += firstMin;
                pqStart.poll();
            }
            else
            {
                ans += secondMin;
                pqEnd.poll();
            }
            hired++;
        }
        return ans;
    }
}