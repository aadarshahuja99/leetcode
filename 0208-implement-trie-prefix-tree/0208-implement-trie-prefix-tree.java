class Trie {
    Trie[] refs;
    boolean isEnd;
    public Trie() {
        refs = new Trie[26]; 
    }
    
    public void insert(String word) {
        Trie current = this;
        for(char c : word.toCharArray())
        {
            int val = c - 'a';
            if(current.refs[val] == null)
            {
                current.refs[val] = new Trie();
            }
            current = current.refs[val];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie current = this;
        for(char c : word.toCharArray())
        {
            int val = c - 'a';
            if(current.refs[val] == null)
            {
                return false;
            }
            current = current.refs[val];
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String word) {
        Trie current = this;
        for(char c : word.toCharArray())
        {
            int val = c - 'a';
            if(current.refs[val] == null)
            {
                return false;
            }
            current = current.refs[val];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */