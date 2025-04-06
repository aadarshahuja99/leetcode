class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        Trie root = new Trie();
        for(String str : wordDict)
        {
            root.insert(str);
            // set.add(str);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        getAns(0, s, root, "");
        return ans;
    }
    private void getAns(int current, String s, Trie root , String sentence)
    {
        int size = s.length();
        if(current == size)
        {
            ans.add(sentence.trim());
        }
        String temp = "";
        Trie node = root;
        for(int i = current; i<size; i++)
        {
            node = node.search(s.charAt(i));
            if(node != null && node.isEnd)
            {
                // System.out.println("match for " + temp);
                getAns(i+1, s, root, sentence + s.substring(current, i+1) + " ");
            }
            if(node == null)
            {
                break;
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