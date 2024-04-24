class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))
        {
            return 0;
        }
        HashSet<String> deadEnds = new HashSet<>();
        for(String deadEnd : deadends)
        {
            deadEnds.add(deadEnd);
        }
        if(deadEnds.contains("0000"))
        {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int moves = 0;
        HashSet<String> visited = new HashSet<>();
        while(queue.size() > 0)
        {
            int size = queue.size();
            moves++;
            for(int i=0; i<size; i++)
            {
                String topCode = queue.poll();
                if(visited.contains(topCode))
                {
                    continue;
                }
                if(topCode.equals(target))
                {
                    return moves-1;
                }
                visited.add(topCode);
                char[] topCodeArray = topCode.toCharArray();
                for(int j=0; j<4; j++)
                {
                    char current = topCodeArray[j];
                    char next = '*';
                    char prev = '*';
                    if(current == '0')
                    {
                        next = '1';
                        prev = '9';
                    }
                    else if(current == '9')
                    {
                        next = '0';
                        prev = '8';
                    }
                    else
                    {
                        next = (char)(current+1);
                        prev = (char)(current-1);
                    }
                    topCodeArray[j] = next;
                    String nextCode = new String(topCodeArray);
                    if(!deadEnds.contains(nextCode) && !visited.contains(nextCode))
                    {
                        queue.add(nextCode);
                    }
                    topCodeArray[j] = prev;
                    String prevCode = new String(topCodeArray);
                    if(!deadEnds.contains(prevCode) && !visited.contains(prevCode))
                    {
                        queue.add(prevCode);
                    }
                    topCodeArray[j] = current;
                }
            }
        }
        return -1;
    }
}