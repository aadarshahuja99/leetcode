class Solution {
    public int minimumCost(String sentence, int k) {
        if(sentence.length() <= k)
        {
            return 0;
        }
        String[] words = sentence.split(" ");
        if(words.length == 1)
        {
            return 0;
        }
        int[] pre = new int[words.length];
        for(int i=0; i<words.length; i++)
        {
            pre[i] += words[i].length() + (i > 0 ? pre[i-1] + 1 : 0);
        }
        int n = words.length;
        int[][] cache = new int[n][n+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getMinCost(0, 0, pre, k, cache);
    }
    private int getMinCost(int currentIndex, int lastCutIndex, int[] pre, int k, int[][] cache)
    {
        // front-partitioning dp question
        if(currentIndex == pre.length-1)
        {
            if(lastCutIndex == 0 || pre[currentIndex] - pre[lastCutIndex-1] - 1 > k)
            {
                return 25*1000000;
            }
            return 0;
        }
        if(cache[currentIndex][lastCutIndex] != -1)
        {
            return cache[currentIndex][lastCutIndex];
        }
        if(lastCutIndex == 0)
        {
            if(pre[currentIndex] > k)
            {
                return cache[currentIndex][lastCutIndex] = 25*1000000;
            }
            return cache[currentIndex][lastCutIndex] = Math.min((int)Math.pow(k-pre[currentIndex],2) + getMinCost(currentIndex+1, currentIndex+1, pre, k, cache),
            getMinCost(currentIndex+1, lastCutIndex, pre, k, cache));
        }
        // System.out.println(pre[currentIndex] - pre[lastCutIndex-1] - 1+" "+currentIndex+" "+(lastCutIndex-1));
        if(pre[currentIndex] - pre[lastCutIndex-1] - 1 <= k)
        {
            return cache[currentIndex][lastCutIndex] = Math.min((int)Math.pow(k - pre[currentIndex] + pre[lastCutIndex-1] + 1, 2) + getMinCost(currentIndex+1, currentIndex+1, pre, k, cache),
            getMinCost(currentIndex+1, lastCutIndex, pre, k, cache));
        }
        return cache[currentIndex][lastCutIndex] = 25*1000000;
    }
}