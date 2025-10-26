class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] cache = new int[n1+1][n2+1];
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

        // finding the SCS
        int i=n1, j=n2;
        StringBuilder ans = new StringBuilder();
        while(i > 0 && j > 0)
        {
            if(text1.charAt(i-1) == text2.charAt(j-1))
            {
                ans.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else if(cache[i-1][j] >= cache[i][j-1])
            {
                ans.append(text1.charAt(i-1));
                i--;
            }
            else
            {
                ans.append(text2.charAt(j-1));
                j--;
            }
        }
        while(i > 0)
        {
            ans.append(text1.charAt(i-1));
            i--;
        }
        while(j > 0)
        {
            ans.append(text2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }
}