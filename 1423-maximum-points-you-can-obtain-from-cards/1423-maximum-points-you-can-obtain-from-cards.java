class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // 2 pointers
        int front = 0;
        for(int i=0; i<k; i++)
        {
            front += cardPoints[i];
        }
        int ans = front;
        int it = cardPoints.length-1;
        int startIndex = k-1;
        while(it >= cardPoints.length-k)
        {
            front = front - cardPoints[startIndex] + cardPoints[it];
            ans = Math.max(ans, front);
            it--;
            startIndex--;
        }
        return ans;
    }
}