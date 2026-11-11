class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[][] cache = new int[n][shelfWidth+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getMinHeight(0, 0, 0, shelfWidth, books, cache);
    }
    private int getMinHeight(int currentIndex, int currentWidth, int maxHeightOfCurrentLevel, int shelfWidth, int[][] books, int[][] cache)
    {
        if(currentIndex == books.length)
        {
            return maxHeightOfCurrentLevel;
        }
        if(cache[currentIndex][currentWidth] != -1)
        {
            return cache[currentIndex][currentWidth];
        }
        // no need to memoize on the basis of next height, we need to memoize the index as it helps us in deciding the base case.
        // we memoized the width because it helps us in checking if the current level is full and a new level is to be started.
        // height of the current level DOES NOT AFFECT the decision
        int moveNext = maxHeightOfCurrentLevel +
        getMinHeight(currentIndex + 1, books[currentIndex][0], 
        books[currentIndex][1], shelfWidth, books, cache);

        if(currentWidth + books[currentIndex][0] <= shelfWidth)
        {
            return cache[currentIndex][currentWidth] = Math.min(moveNext, getMinHeight(currentIndex + 1, 
            currentWidth + books[currentIndex][0], Math.max(books[currentIndex][1], maxHeightOfCurrentLevel), 
            shelfWidth, books, cache));
        }
        return cache[currentIndex][currentWidth] = moveNext;
    }
}