class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
        });
        int n = s.length();
        boolean[] removed = new boolean[n];
        int i = 0;
        for(char c : s.toCharArray())
        {
            if(c == '*')
            {
                if(pq.size() > 0)
                {
                    int[] top = pq.poll();
                    removed[top[1]] = true;
                }
                removed[i] = true;
                i++;
                continue;
            }
            int index = c-'a';
            pq.add(new int[] { index, i });
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(int it=0; it<s.length(); it++)
        {
            // System.out.println(removed[it]+" "+it);
            if(!removed[it])
            {
                sb.append(s.charAt(it));
            }
        }
        return sb.toString();
    }
}