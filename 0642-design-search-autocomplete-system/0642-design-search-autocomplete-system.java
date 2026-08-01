class AutocompleteSystem {
    Trie root;
    Trie current;
    StringBuilder sentence;
    public AutocompleteSystem(String[] sentences, int[] times) {
        int n = sentences.length;
        root = new Trie();
        current = root;
        for(int i=0; i<n; i++)
        {
            root.insert(sentences[i], times[i]);
        }
        sentence = new StringBuilder();
    }
    
    public List<String> input(char c) {
        if(c == '#')
        {
            root.insert(sentence.toString(), 1);
            current = root;
            sentence = new StringBuilder();
            return new ArrayList<String>();
        }
        else
        {
            sentence.append(c);
            if(current == null)
            {
                return new ArrayList<String>();
            }
            var output = current.search(c);
            current = output.getKey();
            return output.getValue();
        }
    }

    class Trie
    {
        HashMap<Character,Trie> references;
        int sentences;
        String s;
        public Trie()
        {
            references = new HashMap<>();
            sentences = 0;
            s = "";
        }

        public void insert(String sentence, int times)
        {
            Trie current = this;
            for(char c : sentence.toCharArray())
            {
                if(!current.references.containsKey(c))
                {
                    current.references.put(c, new Trie());
                }
                current = current.references.get(c);
            }
            current.sentences += times;
            current.s = sentence;
        }
        public Pair<Trie,List<String>> search(char c)
        {
            List<String> ans = new ArrayList<>();
            Trie current = this;
            if(current == null || !current.references.containsKey(c))
            {
                return new Pair<>(null, ans);
            }
            current = current.references.get(c);
            PriorityQueue<Trie> pq = new PriorityQueue<>((a,b) -> a.sentences == b.sentences ? b.s.compareTo(a.s) : a.sentences - b.sentences);
            getAns(current, pq);
            while(pq.size() > 0)
            {
                ans.add(pq.poll().s);
            }
            Collections.reverse(ans);
            return new Pair<>(current,ans);
        }
        private void getAns(Trie current, PriorityQueue<Trie> pq)
        {
            if(current.sentences > 0)
            {
                pq.add(current);
                if(pq.size() > 3)
                {
                    pq.poll();
                }
            }
            for(var entry : current.references.entrySet())
            {
                getAns(entry.getValue(), pq);
            }
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */