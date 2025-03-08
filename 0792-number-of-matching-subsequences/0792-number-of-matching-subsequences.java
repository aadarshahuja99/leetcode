class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // brute force will give tle. Use Kansal sir's idea of hashing
        int length = s.length();
        int[][] hash = new int[length][26];
        // populating the last row
        Arrays.fill(hash[length-1], -1);
        for(int i=length-2; i>=0; i--)
        {
            int nextAlphabetIndex = s.charAt(i+1) - 97;
            hash[i][nextAlphabetIndex] = i+1;
            for(int j=0; j<26; j++)
            {
                if(j == nextAlphabetIndex)
                {
                    continue;
                }
                hash[i][j] = hash[i+1][j];
            }
        }
        int[] firsts = new int[26];
        firsts[s.charAt(0) - 97] = 0;
        for(int i=0; i<26; i++)
        {
            if(i == s.charAt(0) - 97)
            {
                continue;
            }
            firsts[i] = hash[0][i];
        }
        int count = 0;
        for(String currentWord : words)
        {
            int firstAlphabetIndex = currentWord.charAt(0) - 97;
            if(firsts[firstAlphabetIndex] == -1)
            {
                continue;
            }
            int currentIndex = firsts[firstAlphabetIndex];
            boolean isSubsequence = true;
            for(int i=1; i < currentWord.length(); i++)
            {
                // System.out.println(currentWord+" "+i+" "+currentIndex);
                int alphabetIndex = currentWord.charAt(i) - 97;
                if(hash[currentIndex][alphabetIndex] == -1)
                {
                    isSubsequence = false;
                    break;
                }
                currentIndex = hash[currentIndex][alphabetIndex];
                // System.out.println("newCurrentIndex "+currentIndex);
            }
            if(isSubsequence)
            {
                count++;
            }
        }
        return count;
    }
}