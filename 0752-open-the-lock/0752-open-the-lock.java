class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> badSet = new HashSet<>();
        for(String deadEnd : deadends)
        {
            badSet.add(deadEnd);
        }
        if(badSet.contains("0000"))
        {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.add("0000");
        vis.add("0000");
        int levels = 0;
        while(q.size() > 0)
        {
            levels++;
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                var top = q.poll();
                if(top.equals(target))
                {
                    return levels-1;
                }
                char[] arr = top.toCharArray();
                for(int j=0; j<4; j++)
                {
                    char c = arr[j];
                    // increase
                    int next = ((c - '0') + 1)%10;
                    arr[j] = (char)(next+'0');
                    String nextString = new String(arr);
                    if(!vis.contains(nextString) && !badSet.contains(nextString))
                    {
                        vis.add(nextString);
                        q.add(nextString);
                    }
                    arr[j] = c;
                    // decrease
                    int prev = ((c - '0') - 1 + 10)%10; 
                    arr[j] = (char)(prev+'0');
                    String prevString = new String(arr);
                    if(!vis.contains(prevString) && !badSet.contains(prevString))
                    {
                        vis.add(prevString);
                        q.add(prevString);
                    }
                    arr[j] = c;
                }
            }
        }
        return -1;
    }
}