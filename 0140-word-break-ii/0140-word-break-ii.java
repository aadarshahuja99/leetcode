class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        Trie root = new Trie();
        for(String str : wordDict)
        {
            root.insert(str);
        }
        getAns(0, s, root, new ArrayList<>());
        return ans;
    }
    private void getAns(int current, String s, Trie root , ArrayList<String> sentence)
    {
        int size = s.length();
        if(current == size)
        {
            ans.add(String.join(" ", sentence));
        }
        String temp = "";
        Trie node = root;
        for(int i = current; i<size; i++)
        {
            node = node.search(s.charAt(i));
            if(node == null)
            {
                break;
            }
            if(node.isEnd)
            {
                sentence.add(s.substring(current, i+1));
                getAns(i+1, s, root, sentence);
                sentence.remove(sentence.size() - 1);
            }
        }
    }
    class Trie
    {
        public boolean isEnd;
        public Trie[] refs;
        public Trie()
        {
            isEnd = false;
            refs = new Trie[26];
        }
        public void insert(String s)
        {
            Trie current = this;
            for(char c : s.toCharArray())
            {
                int index = c - 'a';
                if(current.refs[index] == null)
                {
                    current.refs[index] = new Trie();
                }
                current = current.refs[index];
            }
            current.isEnd = true;
        }
        public Trie search(char c)
        {
            Trie current = this;
            int index = c - 'a';
            current = current.refs[index];
            return current;
        }
    }
}