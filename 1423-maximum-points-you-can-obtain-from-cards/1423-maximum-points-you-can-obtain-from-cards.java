class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int current = 0;
        int n = cardPoints.length;
        for(int i=0; i<k; i++)
        {
            current += cardPoints[i];
        }
        int ans = current;
        int it = 1;
        while(it <= k)
        {
            current = current - cardPoints[k - it] + cardPoints[n - it];
            ans = Math.max(ans, current);
            it++;
        }
        return ans;
    }
}