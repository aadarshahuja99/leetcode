class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (a,b) -> {
            if(a.get(1).equals(b.get(1)))
            {
                return b.get(0).compareTo(a.get(0));
            }
            return Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1));
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        HashSet<Integer> online = new HashSet<>();
        for(int i=0; i<numberOfUsers; i++)
        {
            online.add(i);
        }
        int allCount = 0;
        int[] counts = new int[numberOfUsers];
        for(var event : events)
        {
            int currentTime = Integer.parseInt(event.get(1));
            while(pq.size() > 0 && pq.peek()[0] <= currentTime)
            {
                online.add(pq.poll()[1]);
            }
            if(event.get(0).equals("MESSAGE"))
            {
                if(event.get(2).equals("ALL"))
                {
                    allCount++;
                }
                else
                {
                    if(event.get(2).equals("HERE"))
                    {
                        for(int user : online)
                        {
                            counts[user]++;
                        }
                    }
                    else
                    {
                        String[] arr = event.get(2).split(" ");
                        for(var user : arr)
                        {
                            int id = 0;
                            for(int it = 2; it < user.length(); it++)
                            {
                                id = id*10 + (user.charAt(it) - '0');
                            }
                            counts[id]++;
                        }
                    }
                }
            }
            else
            {
                int id = Integer.parseInt(event.get(2));
                online.remove(id);
                pq.add(new int[] { currentTime + 60, id });
            }
        }
        for(int i=0; i<numberOfUsers; i++)
        {
            counts[i] += allCount;
        }
        return counts;
    }
}