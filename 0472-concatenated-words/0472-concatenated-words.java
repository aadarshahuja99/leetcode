class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for(String word : words)
        {
            trie.insert(word);
        }
        List<String> ans = new ArrayList<String>();
        for(String word : words)
        {
            int[] dp = new int[word.length()];
            Arrays.fill(dp,-1);
            int components = checkForConcatenation(0,word,trie,dp);
            if(components > 1)
            {
                ans.add(word);
            }
        }
        return ans;
    }
    private int checkForConcatenation(int currentIndex, String word, Trie trie, int[] dp)
    {
        if(currentIndex == word.length())
        {
            return 0;
        }
        if(dp[currentIndex] != -1)
        {
            return dp[currentIndex];
        }
        String temp = "";
        int ans = 0;
        for(int i=currentIndex; i<word.length(); i++)
        {
            temp += word.charAt(i);
            if(trie.search(temp))
            {
                ans = Math.max(ans, 1 + checkForConcatenation(i+1,word,trie,dp));
            }
        }
        return dp[currentIndex] = ans;
    }
    class Trie
    {
        private Trie[] references;
        private boolean isEnd;
        public Trie()
        {
            references = new Trie[26];
            isEnd = false;
        }
        public void insert(String word)
        {
            Trie current = this;
            for(char c : word.toCharArray())
            {
                int index = c - 97;
                if(current.references[index] != null)
                {
                    current = current.references[index];
                }
                else
                {
                    current.references[index] = new Trie();
                    current = current.references[index];
                }
            }
            current.isEnd = true;
        }
        public boolean search(String word)
        {
            Trie current = this;
            for(char c : word.toCharArray())
            {
                int index = c - 97;
                if(current.references[index] != null)
                {
                    current = current.references[index];
                }
                else
                {
                    return false;
                }
            }
            return current.isEnd;
        }
    }
}