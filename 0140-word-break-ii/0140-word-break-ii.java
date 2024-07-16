class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict)
        {
            // root.insert(str);
            set.add(str);
        }
        getAns(0, s, set, "");
        return ans;
    }
    private void getAns(int current, String s, HashSet<String> root , String sentence)
    {
        int size = s.length();
        if(current == size)
        {
            ans.add(sentence.trim());
        }
        String temp = "";
        for(int i = current; i<size; i++)
        {
            temp += s.charAt(i);
            if(root.contains(temp))
            {
                // System.out.println("match for " + temp);
                getAns(i+1, s, root, sentence + temp + " ");
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
        public boolean search(String s)
        {
            Trie current = this;
            for(char c : s.toCharArray())
            {
                int index = c - 'a';
                if(current.refs[index] == null)
                {
                    return false;
                }
                current = current.refs[index];
            }
            return current.isEnd;
        }
    }
}