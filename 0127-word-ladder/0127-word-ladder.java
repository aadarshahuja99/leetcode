class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> words) {
        Queue<String> q = new LinkedList<>();
        int distance = 0;
        q.add(beginWord);
        HashSet<String> vis = new HashSet<>();
        vis.add(beginWord);
        while(q.size() > 0)
        {
            int s = q.size();
            distance++;
            for(int i=0; i<s; i++)
            {
                String top = q.poll();
                if(top.equals(endWord))
                {
                    return distance;
                }
                for(String word : words)
                {
                    if(compare(word, top) && !vis.contains(word))
                    {
                        // System.out.println("added "+word+" at distance "+(distance+1));
                        vis.add(word);
                        q.add(word);
                    }
                }
            }
        }
        return 0;
    }
    private boolean compare(String w1, String w2)
    {
        int diff = 0;
        for(int i=0; i<w1.length(); i++)
        {
            if(w1.charAt(i) != w2.charAt(i))
            {
                diff++;
                if(diff > 1)
                {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}