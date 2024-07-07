class Solution {
    Trie root;
    public int minimumCost(String target, String[] words, int[] costs) {
        root = new Trie();
        int idx = 0;
        for(String word : words)
        {
            root.insert(word, costs[idx]);
            idx++;
        }
        int[] cache = new int[target.length()];
        Arrays.fill(cache, -1);
        int ans = getAns(0, target, cache);
        if(ans > 5*100000000)
        {
            return -1;
        }
        return ans;
    }
    private int getAns(int currentIndex, String target, int[] cache)
    {
        if(currentIndex == target.length())
        {
            return 0;
        }
        if(cache[currentIndex] != -1)
        {
            return cache[currentIndex];
        }
        int ans = 5*100000000 + 1;
        Trie current = root;
        for(int i=currentIndex; i<target.length(); i++)
        {
            int index = target.charAt(i) - 'a';
            current = current.search(index);
            if(current == null)
            {
                // System.out.println("1: "+currentIndex+", "+ans);
                return cache[currentIndex] = ans;
            }
            if(current.isEnd)
            {
                ans = Math.min(ans, current.cost + getAns(i+1, target, cache));
            }
        }
        // System.out.println("2: "+currentIndex+", "+ans);
        return cache[currentIndex] = ans;
    }
    class Trie
    {
        Trie[] references;
        int cost;
        boolean isEnd;
        public Trie()
        {
            references = new Trie[26];
            cost = 10001;
            isEnd = false;
        }
        public void insert(String word, int cost)
        {
            Trie current = this;
            for(char c : word.toCharArray())
            {
                int alphabetIndex = c - 'a';
                if(current.references[alphabetIndex] == null)
                {
                    current.references[alphabetIndex] = new Trie();
                }
                current = current.references[alphabetIndex];
            }
            current.cost = Math.min(cost, current.cost);
            current.isEnd = true;
        }
        public Trie search(int index)
        {
            Trie current = this;
            if(current.references[index] == null)
            {
                return null;
            }
            return current.references[index];
        }
    }
}