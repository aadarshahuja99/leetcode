class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int count = 0;
        int[][] prefixSums = new int[n][26];
        int[] suffixSums = new int[26];
        HashSet<Integer>[] sets = new HashSet[26];
        for(int i=0; i<26; i++)
        {
            sets[i] = new HashSet<>();
        }
        for(int i=1; i<n; i++)
        {
            int c = s.charAt(i-1) - 'a';
            for(int j=0; j<26; j++)
            {
                prefixSums[i][j] = prefixSums[i-1][j];
            }
            prefixSums[i][c] += 1;
        }
        for(int i=n-2; i>=1; i--)
        {
            int c = s.charAt(i+1) - 'a';
            suffixSums[c]++;
            for(int j=0; j<26; j++)
            {
                int limit = Math.min(suffixSums[j], prefixSums[i][j]);
                if(!sets[s.charAt(i) - 'a'].contains(j) && limit > 0)
                {
                    count++;
                    sets[s.charAt(i) - 'a'].add(j);
                }
            }
        }
        return count;
    }
}