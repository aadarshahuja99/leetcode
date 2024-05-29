class Solution {
    public String reorganizeString(String s) {
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
            char c = (char)(97 + top[0]);
            top[1]--;
            queue.add(top);
            sb.append(c);
            if(queue.size() == 2)
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