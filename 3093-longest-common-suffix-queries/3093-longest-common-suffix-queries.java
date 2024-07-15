class Solution {
    public String[] words;
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        words = wordsContainer;
        Trie trie = new Trie();
        int idx = 0;
        int shortestIndex = -1;
        int shortest = 5001;
        for(String word : words)
        {
            if(word.length() < shortest)
            {
                shortest = word.length();
                shortestIndex = idx;
            }
            trie.insert(word, idx);
            idx++;
        }
        int[] ans = new int[wordsQuery.length];
        for(int i=0; i<wordsQuery.length; i++)
        {
            ans[i] = trie.find(wordsQuery[i]);
            if(ans[i] == -1)
            {
                ans[i] = shortestIndex;
            }
        }
        return ans;
    }
    class Trie
    {
        public Trie[] refs;
        public int id;
        public int length;
        public Trie()
        {
            refs = new Trie[26];
            id = -1;
            length = 5001;
        }
        public void insert(String s, int containerIndex)
        {
            Trie current = this;
            for(int i=s.length()-1; i>=0; i--)
            {
                int idx = s.charAt(i) - 97;
                if(current.refs[idx] != null)
                {
                    current = current.refs[idx];
                }
                else
                {
                    current.refs[idx] = new Trie();
                    current = current.refs[idx];
                }
                if(s.length() < current.length)
                {
                    current.length = s.length();
                    current.id = containerIndex;
                }
            }
        }
        public int find(String word)
        {
            Trie current = this;
            int ans = -1;
            for(int i=word.length()-1; i>=0; i--)
            {
                int idx = word.charAt(i) - 97;
                if(current.refs[idx] != null)
                {
                    current = current.refs[idx];
                    ans = current.id;
                }
                else
                {
                    break;
                }
            }
            return ans;
        }
    }
}