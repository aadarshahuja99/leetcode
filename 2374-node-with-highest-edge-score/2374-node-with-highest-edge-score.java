class Solution {
    public int edgeScore(int[] edges) {
        long[] score = new long[edges.length];
        for(int i=0; i<edges.length; i++)
        {
            score[edges[i]] += i;
        }
        long ans = Long.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<score.length; i++)
        {
            // System.out.println("score: " + score[i]);
            if(score[i] > ans)
            {
                ans = score[i];
                idx = i;
            }
        }
        return idx;
    }
}