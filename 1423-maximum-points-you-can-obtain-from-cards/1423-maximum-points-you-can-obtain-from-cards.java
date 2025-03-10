class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int current = 0;
        for(int i=0; i<k; i++)
        {
            current += cardPoints[i];
        }
        int ans = current;
        int j=cardPoints.length-1;
        int it = 1;
        while(j >= cardPoints.length - k)
        {
            current = current - cardPoints[k-it] + cardPoints[j];
            // System.out.println("ns "+current + " at "+ j);
            ans = Math.max(ans, current);
            j--;
            it++;
        }
        return ans;
    }
}