class Solution {
    public String rearrangeString(String s, int k) {
        if(k <= 1)
        {
            return s;
        }
        int[][] counts = new int[26][2];
        for(int i=0; i<26; i++)
        {
            counts[i][0] = i;
        }
        for(char c : s.toCharArray())
        {
            counts[c-97][1]++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            return b[1] - a[1];
        });
        for(int i=0; i<26; i++)
        {
            if(counts[i][1] > 0)
            {
                maxHeap.add(counts[i]);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size() > 0)
        {
            int[] top = maxHeap.poll();
            char c = (char)('a' + top[0]);
            top[1]--;
            // System.out.println(c+" "+top[1]);
            sb.append(c);
            queue.add(top);
            if(queue.size() == k)
            {
                var queueTop = queue.poll();
                if(queueTop[1] > 0)
                {
                    maxHeap.add(queueTop);
                }
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}