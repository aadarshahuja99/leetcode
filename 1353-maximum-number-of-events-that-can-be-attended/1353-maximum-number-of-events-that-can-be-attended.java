class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int n = events.length;
        int ans = 0;
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int currentDay = 0;
        while(i < n || !pq.isEmpty())
        {
            if(pq.isEmpty())
            {
                currentDay = events[i][0];
            }
            while(i < n && events[i][0] <= currentDay)
            {
                pq.add(events[i][1]); // add the end day of the event
                i++;
            }
            pq.poll();
            ans++; // attend an event that ends the earliest
            currentDay++;
            // remove events that can not be attended
            while(!pq.isEmpty() && pq.peek() < currentDay)
            {
                pq.poll();
            }
        }
        return ans;
    }
}