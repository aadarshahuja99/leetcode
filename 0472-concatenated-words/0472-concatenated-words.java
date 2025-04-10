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
        int ans = 0;
        Trie current = trie;
        for(int i=currentIndex; i<word.length(); i++)
        {
            current = current.search(word.charAt(i));
            if(current == null)
            {
                break;
            }
            if(current.isEnd)
            {
                int rem = checkForConcatenation(i+1,word,trie,dp);
                if(rem == 0 && i != word.length() - 1)
                {
                    continue;
                }
                ans = Math.max(ans, 1 + rem);
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
        public Trie search(char c)
        {
            Trie current = this;
            int index = c - 97;
            if(current.references[index] != null)
            {
                current = current.references[index];
            }
            else
            {
                return null;
            }
            return current;
        }
    }
}