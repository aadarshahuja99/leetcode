class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for(String word : words)
        {
            trie.insert(word);
        }
        int[] ans = new int[words.length];
        int idx = 0;
        for(String word : words)
        {
            ans[idx] = trie.search(word);
            idx++;
        }
        return ans;
    }
    class Trie
    {
        Trie[] references;
        int count;
        public Trie()
        {
            references = new Trie[26];
            count = 0;
        }

        public void insert(String word)
        {
            Trie current = this;
            for(char c : word.toCharArray())
            {
                int alphabetIndex = c - 97;
                if(current.references[alphabetIndex] == null)
                {
                    current.references[alphabetIndex] = new Trie();
                }
                current = current.references[alphabetIndex];
                current.count++;
            }
        }

        public int search(String word)
        {
            Trie current = this;
            int numberOfCommonPrefixes = 0;
            for(char c : word.toCharArray())
            {
                int alphabetIndex = c - 97;
                current = current.references[alphabetIndex];
                numberOfCommonPrefixes += current.count;
            }
            return numberOfCommonPrefixes;
        }
    }
}