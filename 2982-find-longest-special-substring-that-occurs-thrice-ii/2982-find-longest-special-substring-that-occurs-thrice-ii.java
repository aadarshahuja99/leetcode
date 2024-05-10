class Solution {
    public int maximumLength(String s) {
        // a special substring has only 1 unique character and there are 26 characters in alphabet.
        // for each character maintain an array of size n+1 (to store counts of substrings having length from 1 to n)
        int n = s.length();
        int[][] countHash = new int[26][n+1];
        int runningLength = 0;
        char lastAlphabet = (int)(0);
        for(int i=0; i<n; i++)
        {
            char c = s.charAt(i);
            int alphabetIndex = c-97;
            if(i > 0 && lastAlphabet == s.charAt(i))
            {
                runningLength++;
                countHash[alphabetIndex][runningLength]++;
            }
            else
            {
                countHash[alphabetIndex][1]++;
                runningLength = 1;
                lastAlphabet = c;
            }
        }
        int ans = 0;
        for(int i=0; i<26; i++)
        {
            int count = 0;
            System.out.println((char)(i + 97));
            for(int j=n; j>=1; j--)
            {
                // System.out.println(countHash[i][j]+" "+j);
                count += countHash[i][j];
                if(count >= 3)
                {
                    ans = Math.max(ans, j);
                    break;
                }
            }
        }
        return ans == 0 ? -1 : ans;
    }
}