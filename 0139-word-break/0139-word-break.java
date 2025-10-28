class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for(String word : wordDict)
        {
            root.add(word);
        }
        Boolean[] cache = new Boolean[s.length()];
        return getAns(0, s, root, cache);
    }
    private boolean getAns(int current, String s, Trie root, Boolean[] cache)
    {
        if(current == s.length())
        {
            return true;
        }
        if(cache[current] != null)
        {
            return cache[current];
        }
        Trie trie = root;
        boolean ans = false;
        for(int i=current; i<s.length(); i++)
        {
            char c = s.charAt(i);
            trie = trie.search(c);
            if(trie == null)
            {
                return cache[current] = false;
            }
            if(trie.isEnd)
            {
                ans = ans | getAns(i+1, s, root, cache);
            }
            if(ans == true)
            {
                return cache[current] = true;
            }
        }
        return cache[current] = ans;
    }
    class Trie
    {
        boolean isEnd;
        Trie[] refs;
        Trie()
        {
            isEnd = false;
            refs = new Trie[26];
        }
        public void add(String s)
        {
            Trie current = this;
            for(char ch : s.toCharArray())
            {
                int index = ch - 'a';
                if(current.refs[index] != null)
                {
                    current = current.refs[index];
                }
                else
                {
                    current.refs[index] = new Trie();
                    current = current.refs[index];
                }
            }
            current.isEnd = true;
        }
        public Trie search(Character c)
        {
            Trie current = this;
            int index = c-'a';
            if(current.refs[index] == null)
            {
                return null;
            }
            current = current.refs[index];
            return current;
        }
    }
}