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
        char[] start = {'0','0','0','0'};
        Queue<char[]> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.add(start);
        int levels = 0;
        while(q.size() > 0)
        {
            levels++;
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                var top = q.poll();
                String topString = new String(top);
                if(topString.equals(target))
                {
                    return levels-1;
                }
                for(int j=0; j<4; j++)
                {
                    char c = top[j];
                    // increase
                    int next = ((c - '0') + 1)%10;
                    String nextString = "";
                    for(int k=0; k<4; k++)
                    {
                        if(j == k)
                        {
                            nextString += next;
                        }
                        else
                        {
                            nextString += top[k];
                        }
                    }
                    if(!vis.contains(nextString) && !badSet.contains(nextString))
                    {
                        vis.add(nextString);
                        q.add(nextString.toCharArray());
                    }

                    // decrease
                    int prev = ((c - '0') - 1 + 10)%10; 
                    String prevString = "";
                    for(int k=0; k<4; k++)
                    {
                        if(j == k)
                        {
                            prevString += prev;
                        }
                        else
                        {
                            prevString += top[k];
                        }
                    }
                    if(!vis.contains(prevString) && !badSet.contains(prevString))
                    {
                        vis.add(prevString);
                        q.add(prevString.toCharArray());
                    }
                }
            }
        }
        return -1;
    }
}