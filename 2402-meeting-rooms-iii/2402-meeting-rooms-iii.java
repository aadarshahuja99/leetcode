class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Arrays.sort(meetings, (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        });
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++)
        {
            set.add(i);
        }
        int i=0;
        int delay = 0;
        while(i < meetings.length)
        {
            while(pq.size() > 0 && pq.peek()[1] <= meetings[i][0])
            {
                set.add(pq.poll()[0]);
            }
            if(pq.size() == n)
            {
                int[] top = pq.poll();
                count[top[0]]++;
                delay += top[1] - (meetings[i][0] + delay);
                // System.out.println("1: adding "+top[0]+" to queue, new total delay: "+delay+" meeting "+meetings[i][0]+", "+meetings[i][1]+" end time: "+(top[1] +  + meetings[i][1] - meetings[i][0]));
                pq.add(new int[] { top[0], top[1] + meetings[i][1] - meetings[i][0] });
            }
            else
            {
                int first = set.first();
                count[first]++;
                set.remove(first);
                // System.out.println("2: adding "+first+" to queue. Meeting "+meetings[i][0]+", "+meetings[i][1]+" end time: "+ (delay + meetings[i][1] ));
                pq.add(new int[] { first, meetings[i][1] });
            }
            i++;
        }
        int ans = 0;
        int idx = 0;
        int ansIdx = 0;
        for(int num : count)
        {
            if(num > ans)
            {
                ans = num;
                ansIdx = idx;
            }
            idx++;
        }
        return ansIdx;
    }
}