class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        Collections.sort(dictionary, (a,b) -> {
            return a.length() - b.length();
        });
        int idx = 0;
        for(String word : dictionary)
        {
            root.insert(word, idx);
            idx++;
        }
        String[] components = sentence.split(" ");
        int n = components.length;
        idx = 0;
        String[] newSentence = new String[n];
        for(String word : components)
        {
            int index = root.search(word);
            if(index == -1)
            {
                newSentence[idx] = word;
            }
            else
            {
                newSentence[idx] = dictionary.get(index);
            }
            idx++;
        }
        return String.join(" ", newSentence);
    }
    class Trie
    {
        Trie[] references;
        boolean isEndOfWord;
        int wordIndex;
        public Trie()
        {
            references = new Trie[26];
            isEndOfWord = false;
            wordIndex = -1;
        }
        public void insert(String word, int idx)
        {
            Trie current = this;
            for(char c : word.toCharArray())
            {
                int index = c - 'a';
                if(current.references[index] == null)
                {
                    current.references[index] = new Trie();
                }
                current = current.references[index];
            }
            current.wordIndex = idx;
            current.isEndOfWord = true;
            // System.out.println(current.wordIndex+" "+word+" "+idx);
        }
        public int search(String word)
        {
            Trie current = this;
            for(char c : word.toCharArray())
            {
                int index = c - 'a';
                if(current.references[index] == null)
                {
                    return -1;
                }
                if(current.references[index].wordIndex != -1)
                {
                    return current.references[index].wordIndex;
                }
                current = current.references[index];
            }
            return current.wordIndex;
        }
    }
}