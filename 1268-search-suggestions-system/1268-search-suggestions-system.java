class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String product : products)
        {
            trie.insert(product);
        }
        ArrayList<List<String>> output = new ArrayList<>();
        Trie current = trie;
        String searched = "";
        for(char c : searchWord.toCharArray())
        {
            searched += c;
            var ans = trie.search(c, current, searched);
            current = ans.getKey();
            output.add(ans.getValue());
        }
        return output;
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
                int index = c - 97;
                if(current.references[index] == null)
                {
                    current.references[index] = new Trie();
                }
                current = current.references[index];
            }
            current.isEndOfWord = true;
        }
        public Pair<Trie,List<String>> search(char c, Trie begin, String last)
        {
            Trie current = begin;
            int index = c - 97;
            if(current != null && current.references[index] != null)
            {
                current = current.references[index];
            }
            else
            {
                current = null;
                return new Pair<Trie,List<String>>(null, new ArrayList<String>());
            }
            List<String> result = new ArrayList<String>();
            dfs(current, last, result);
            return new Pair<Trie,List<String>>(current, result);
        }
        private void dfs(Trie current, String str, List<String> result)
        {
            if(result.size() == 3)
            {
                return;
            }
            if(current.isEndOfWord)
            {
                result.add(str);
            }
            for(int i=0; i<26; i++)
            {
                if(current.references[i] != null)
                {
                    dfs(current.references[i], str+(char)(97+i), result);
                }
            }
        }
    }
}