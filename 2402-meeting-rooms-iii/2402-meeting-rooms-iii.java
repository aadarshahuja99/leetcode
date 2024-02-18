class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>()
        {
            public int compare(int[] m1, int[] m2)
            {
                return m1[0]-m2[0];
            }
        });
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> active = new PriorityQueue<int[]>(new Comparator<int[]>()
        {
            public int compare(int[] p1, int[] p2)
            {
                if(p1[0] != p2[0])
                {
                    return p1[0] - p2[0];
                }
                return p1[1] - p2[1];
            }
        });
        active.add(new int[] {0,0});
        for(int i=0; i<meetings.length; i++)
        {
            q.add(meetings[i]);
        }
        int[] count = new int[n];
        int current = 0;
        while(q.size() > 0)
        {
            var queueTop = q.poll();
            int newEnd = queueTop[1];
            int size = active.size();
            int it = 0;
            List<int[]> list = new ArrayList<>();
            while(it < size && active.peek()[0] <= queueTop[0])
            {
                list.add(active.poll());
                it++;
                // System.out.println(active.size());
            }
            for(var pair : list)
            {
                // System.out.println("updating room "+pair[1]);
                active.add(new int[]{ 0,pair[1] });
            }
            // System.out.println(active.size()+" "+active.peek());
            var pqTop = active.peek();
            if(pqTop[0] > queueTop[0])
            {
                if(current < n-1)
                {
                    count[current+1]++;
                    current++;
                    // System.out.println("1 assigning "+queueTop[0]+","+queueTop[1]+" to "+current);
                    active.add(new int[] {newEnd,current});
                }
                else
                {
                    newEnd += pqTop[0] - queueTop[0];
                    active.poll();
                    count[pqTop[1]]++;
                    // System.out.println("2 assigning "+queueTop[0]+","+queueTop[1]+" to "+pqTop[1]);
                    active.add(new int[] {newEnd,pqTop[1]});
                }
            }
            else
            {
                active.poll();
                count[pqTop[1]]++;
                // System.out.println("3 assigning "+queueTop[0]+","+queueTop[1]+" to "+pqTop[1]);
                active.add(new int[] {newEnd,pqTop[1]});
            }
        }
        int ans = 0;
        int element = 0;
        for(int i=0; i<n; i++)
        {
            if(ans < count[i])
            {
                ans = count[i];
                element = i;
            }
        }
        return element;
    }
}