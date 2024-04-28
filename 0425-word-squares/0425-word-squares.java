class Solution {
    public List<List<String>> wordSquares(String[] words) {
        ArrayList<List<String>> ans = new ArrayList<>();
        int wordLength = words[0].length();
        Trie trie = new Trie();
        int idx = 0;
        for(String word : words)
        {
            trie.insert(word, idx);
            idx++;
        }
        getWordSquares(0, trie, "", new LinkedList<String>(), ans, wordLength, words);
        return ans;
    }

    private void getWordSquares(int currentIndex, Trie trie, String prefix, LinkedList<String> currentList, ArrayList<List<String>> ans, int wordLength, String[] words)
    {
        if(currentIndex == wordLength)
        {
            ans.add(new ArrayList<>(currentList));
            return;
        }
        var candidates = trie.getAllWordsByPrefix(prefix);
        // System.out.println(candidates.size()+ " " + currentIndex+" "+prefix);
        for(int wordIndex : candidates)
        {
            String word = words[wordIndex];
            currentList.addLast(word);
            String newPrefix = "";
            if(currentIndex+1 < wordLength)
            {
                for(String selectedWord : currentList)
                {
                    newPrefix += selectedWord.charAt(currentIndex+1);
                }
            }
            getWordSquares(currentIndex+1, trie, newPrefix, currentList, ans, wordLength, words);
            currentList.removeLast();
        }
    }

    class Trie
    {
        Trie[] references;
        ArrayList<Integer> words;
        public Trie()
        {
            references = new Trie[26];
            words = new ArrayList<>();
        }

        public ArrayList<Integer> getAllWordsByPrefix(String prefix)
        {
            Trie current = this;
            for(char c : prefix.toCharArray())
            {
                int alphabetIndex = c - 97;
                if(current.references[alphabetIndex] != null)
                {
                    current = current.references[alphabetIndex];
                    // idx++;
                }
                else
                {
                    return new ArrayList<>();
                }
            }
            return current.words;
        }

        public void insert(String word, int idx)
        {
            Trie current = this;
            for(char c : word.toCharArray())
            {
                int alphabetIndex = c - 97;
                current.words.add(idx);
                if(current.references[alphabetIndex] != null)
                {
                    current = current.references[alphabetIndex];
                }
                else
                {
                    current.references[alphabetIndex] = new Trie();
                    current = current.references[alphabetIndex];
                }
            }
        }
    }
}