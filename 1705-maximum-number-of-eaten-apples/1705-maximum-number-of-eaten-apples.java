class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Min-heap based on expiry date
        int n = apples.length;
        int ans = 0;
        int currentDay = 0;
        
        while (currentDay < n || !pq.isEmpty()) {
            // Add apples that are available on the current day
            if (currentDay < n && apples[currentDay] > 0) {
                pq.add(new int[] { apples[currentDay], currentDay + days[currentDay] });
            }
            
            // Remove expired apples
            while (!pq.isEmpty() && pq.peek()[1] <= currentDay) {
                pq.poll();
            }
            
            // Eat one apple if available
            if (!pq.isEmpty()) {
                int[] top = pq.poll();
                top[0]--; // Eat one apple
                
                if (top[0] > 0) {
                    pq.add(top); // Add back the remaining apples with the same expiry
                }
                
                ans++;
            }
            
            currentDay++;
        }

        return ans;
    }
}