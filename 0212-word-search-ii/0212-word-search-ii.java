class Solution {
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
                visited[i][j] = true;
                dfs(i, j, board, visited, present, trie);
                visited[i][j] = false;
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
        Trie next = current.search(current, board[row][col]);
        if(next == null)
        {
            return;
        }
        if(next.wordEnds.size() > 0)
        {
            for(int idx : next.wordEnds)
            {
                present.add(idx);
            }
        }
        int[][] moves = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<4; i++)
        {
            int nextRow = row + moves[i][0];
            int nextCol = col + moves[i][1];
            if(validate(nextRow, nextCol, m, n) && !visited[nextRow][nextCol])
            {
                visited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, board, visited, present, next);
                visited[nextRow][nextCol] = false;
            }
        }
    }
    private boolean validate(int r, int c, int m, int n)
    {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
    class Trie
    {
        Trie[] references;
        List<Integer> wordEnds;
        public Trie()
        {
            references = new Trie[26];
            wordEnds = new ArrayList<>();
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
            current.wordEnds.add(index);
        }
        public Trie search(Trie current, char c)
        {
            int alphabetIndex = c - 'a';
            return current.references[alphabetIndex];
        }
    }
}