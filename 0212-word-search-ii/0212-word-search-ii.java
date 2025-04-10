class Solution {
    int[][] moves = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        int m = board.length;
        int n = board[0].length;
        Trie trie = new Trie();
        int it = 0;
        for(String word : words)
        {
            trie.insert(word, it);
            it++;
        }
        HashSet<Integer> present = new HashSet<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                boolean[][] visited = new boolean[m][n];
                dfs(i, j, board, visited, present, trie);
                if(present.size() == words.length)
                {
                    break;
                }
            }
        }
        for(int idx : present)
        {
            ans.add(words[idx]);
        }
        return ans;
    }
    private void dfs(int row, int col, char[][] board, boolean[][] visited, HashSet<Integer> present, Trie current)
    {
        Trie next = current.search(board[row][col]);
        if(next == null)
        {
            return;
        }
        if(next.wordIndex >= 0)
        {
            present.add(next.wordIndex);
        }
        visited[row][col] = true;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<4; i++)
        {
            int nextRow = row + moves[i][0];
            int nextCol = col + moves[i][1];
            if(validate(nextRow, nextCol, m, n) && !visited[nextRow][nextCol])
            {
                dfs(nextRow, nextCol, board, visited, present, next);
            }
        }
        visited[row][col] = false;
    }
    private boolean validate(int r, int c, int m, int n)
    {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
    class Trie
    {
        Trie[] references;
        int wordIndex;
        public Trie()
        {
            references = new Trie[26];
            wordIndex = -1;
        }
        public void insert(String word, int index)
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
            current.wordIndex = index;
        }
        public Trie search(char c)
        {
            int alphabetIndex = c - 'a';
            return this.references[alphabetIndex];
        }
    }
}