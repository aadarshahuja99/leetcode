class Solution {
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()+1][word2.length()+1];
        for(int[] r : cache)
        {
            Arrays.fill(r, -1);
        }
        return getAns(word1.length(), word2.length(), word1, word2, cache);
    }
    private int getAns(int i, int j, String w1, String w2, int[][] cache)
    {
        if(i == 0 && j == 0)
        {
            return 0;
        }
        if(i == 0)
        {
            return j;
        }
        if(j == 0)
        {
            return i;
        }
        if(cache[i][j] != -1)
        {
            return cache[i][j];
        }
        if(w1.charAt(i-1) == w2.charAt(j-1))
        {
            return cache[i][j] = getAns(i-1, j-1, w1, w2, cache);
        }
        return cache[i][j] = 1 + Math.min(getAns(i-1, j, w1, w2, cache), Math.min(getAns(i-1, j-1, w1, w2, cache), getAns(i, j-1, w1, w2, cache)));
    }
}