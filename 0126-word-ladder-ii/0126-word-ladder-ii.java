class Solution {
    class Element
    {
        int val;
        HashSet<String> parents;
        public Element(int v)
        {
            parents = new HashSet<>();
            val = v;
        }
        public void addWord(String w)
        {
            parents.add(w);
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int distance = 0;
        HashMap<String,Element> vis = new HashMap<>();
        boolean shouldBreak = false;
        while(q.size() > 0)
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                var top = q.poll();
                if(top.equals(endWord))
                {
                    // ans computation
                    shouldBreak = true;
                    break;
                }
                for(String s : wordList)
                {
                    if(compare(s, top) && !vis.containsKey(s))
                    {
                        // System.out.println(s+" vis from "+top);
                        vis.put(s, new Element(distance));
                        vis.get(s).addWord(top);
                        q.add(s);
                    }
                    else if(compare(s, top) && vis.get(s).val == distance)
                    {
                        // System.out.println(s+" vis from "+top);
                        vis.get(s).addWord(top);
                    }
                }
            }
            if(shouldBreak)
            {
                break;
            }
            distance++;
        }
        var ans =  new ArrayList<List<String>>();
        if(!shouldBreak)
        {
            return ans;
        }
        backTrack(endWord, ans, vis, new ArrayList<String>(), beginWord);
        return ans;
    }
    private void backTrack(String current, ArrayList<List<String>> ans, HashMap<String,Element> vis, List<String> currentAns, String start)
    {
        currentAns.add(current);
        if(current.equals(start))
        {
            var candidate = new ArrayList<>(currentAns);
            Collections.reverse(candidate);
            ans.add(candidate);
            currentAns.remove(currentAns.size() - 1);
            return;
        }
        for(String word : vis.get(current).parents)
        {
            backTrack(word, ans, vis, currentAns, start);
        }
        currentAns.remove(currentAns.size() - 1);
    }
    private boolean compare(String w1, String w2)
    {
        if(w1.length() != w2.length())
        {
            return false;
        }
        int diff = 0;
        for(int i=0; i<w1.length(); i++)
        {
            if(w1.charAt(i) != w2.charAt(i))
            {
                diff++;
                if(diff == 2)
                {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}