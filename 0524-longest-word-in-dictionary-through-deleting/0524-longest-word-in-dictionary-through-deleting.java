class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int length = s.length();
        Collections.sort(dictionary, (a,b) -> {
            if(a.length() == b.length())
            {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        int[][] hash = new int[length+1][26];
        for(int i=length-2; i>=-1; i--)
        {
            int nextAlphabetIndex = s.charAt(i+1) - 97;
            hash[i+1][nextAlphabetIndex] = i+2;
            for(int j=0; j<26; j++)
            {
                if(j == nextAlphabetIndex)
                {
                    continue;
                }
                hash[i+1][j] = hash[i+2][j];
            }
        }
        
        for(String current : dictionary)
        {
            if(checkIfSubsequence(current, s, hash))
            {
                return current;
            }
        }

        return "";
    }

    private boolean checkIfSubsequence(String target, String source, int[][] hash)
    {
        int currentIndex = 0;
        for(char c : target.toCharArray())
        {
            int alphabetIndex = c - 97;
            if(hash[currentIndex][alphabetIndex] != 0)
            {
                currentIndex = hash[currentIndex][alphabetIndex];
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}