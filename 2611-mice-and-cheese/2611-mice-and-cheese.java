class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int numberOfCheeseTypes = reward1.length;
        int[] differences = new int[numberOfCheeseTypes];
        for(int i=0; i<numberOfCheeseTypes; i++)
        {
            differences[i] = reward1[i] - reward2[i];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        for(int i=0; i<numberOfCheeseTypes; i++)
        {
            pq.add(new int[] { differences[i], i });
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        int ans = 0;
        HashSet<Integer> mice1Indices = new HashSet<>();
        while(pq.size() > 0)
        {
            mice1Indices.add(pq.peek()[1]);
            ans += reward1[pq.poll()[1]];
        }
        for(int i=0; i<numberOfCheeseTypes; i++)
        {
            if(!mice1Indices.contains(i))
            {
                ans += reward2[i];
            }
        }
        return ans;
    }
}