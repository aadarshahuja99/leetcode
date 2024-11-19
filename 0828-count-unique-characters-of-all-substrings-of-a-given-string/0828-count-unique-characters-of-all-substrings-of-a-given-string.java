class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[][] last = new int[n][26];
        int[][] next = new int[n][26];
        for(int[] row : last)
        {
            Arrays.fill(row,-1);
        }
        for(int[] row : next)
        {
            Arrays.fill(row,-1);
        }
        for(int i=1; i<n; i++)
        {
            int alphabetIndex = s.charAt(i-1) - 65;
            for(int j=0; j<26; j++)
            {
                if(j == alphabetIndex)
                {
                    last[i][j] = i-1;
                }
                else
                {
                    last[i][j] = last[i-1][j];
                }
            }
        }
        int ans = 0;
        for(int i=n-2; i>=0; i--)
        {
            int alphabetIndex = s.charAt(i+1) - 65;
            for(int j=0; j<26; j++)
            {
                if(j == alphabetIndex)
                {
                    next[i][j] = i+1;
                }
                else
                {
                    next[i][j] = next[i+1][j];
                }
            }
            int currentAlphabet = s.charAt(i) - 65;
            // System.out.println(last[i][currentAlphabet]+" "+next[i][currentAlphabet]+" for index "+i);
            ans += (i-(last[i][currentAlphabet] == -1 ? 0 : last[i][currentAlphabet]+1)+1)*((
                next[i][currentAlphabet] == -1 ? n-1 : next[i][currentAlphabet]-1) - i + 1);
        }
        int lastAlphabet = s.charAt(n-1) - 65;
        // System.out.println(last[n-1][lastAlphabet]+" for index "+(n-1));
        ans += (n-1-(last[n-1][lastAlphabet] == -1 ? 0 : last[n-1][lastAlphabet]+1)+1);
        return ans;
    }
}