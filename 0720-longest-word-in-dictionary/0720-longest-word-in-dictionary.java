class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words)
        {
            trie.insert(word);
        }
        String ans = "";
        for(String word : words)
        {
            if(trie.search(word))
            {
                if((word.length() > ans.length()) || (word.length() == ans.length() && word.compareTo(ans) < 0))
                {
                    ans = word;
                }
            }
        }
        return ans;
    }

    class Trie
    {
        Trie[] references;
        boolean isEndOfWord;
        public Trie()
        {
            references = new Trie[26];
            isEndOfWord = false;
        }

        public void insert(String s)
        {
            Trie current = this;
            for(char c : s.toCharArray())
            {
                int alphabetIndex = c - 97;
                if(current.references[alphabetIndex] == null)
                {
                    current.references[alphabetIndex] = new Trie();
                }
                current = current.references[alphabetIndex];
            }
            current.isEndOfWord = true;
        }

        public boolean search(String s)
        {
            Trie current = this;
            boolean isCandidate = true;
            for(char c : s.toCharArray())
            {
                int alphabetIndex = c - 97;
                if(current.references[alphabetIndex] == null)
                {
                    break;
                }
                current = current.references[alphabetIndex];
                isCandidate = isCandidate && current.isEndOfWord;
            }
            return isCandidate;
        }
    }
}