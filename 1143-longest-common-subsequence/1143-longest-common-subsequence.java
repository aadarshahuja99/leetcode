class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] cache = new int[n1+2][n2+2];
        for(int it1 = 1; it1 <= text1.length(); it1++)
        {
            for(int it2 = 1; it2 <= text2.length(); it2++)
            {
                if(text1.charAt(it1 - 1) == text2.charAt(it2 - 1))
                {
                    cache[it1][it2] = cache[it1-1][it2-1] + 1;
                }
                else
                {
                    cache[it1][it2] = Math.max(cache[it1-1][it2], cache[it1][it2-1]);
                }
            }
        }
        return cache[n1][n2];
    }
}