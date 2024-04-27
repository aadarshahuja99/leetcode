class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps = getLpsArray(s);
        int lengthOfTheGivenString = s.length();
        if(lps[lengthOfTheGivenString-1] == 0)
        {
            return false;
        }
        int lengthOfRepeatingSubstring = lengthOfTheGivenString - lps[lengthOfTheGivenString-1];
        return lengthOfTheGivenString%lengthOfRepeatingSubstring == 0;
    }
    private int[] getLpsArray(String s)
    {
        int currentIndex = 1;
        int length = 0;
        int[] lps = new int[s.length()];
        while(currentIndex < s.length())
        {
            if(s.charAt(currentIndex) == s.charAt(length))
            {
                lps[currentIndex] = length+1;
                length++;
                currentIndex++;
            }
            else
            {
                if(length == 0)
                {
                    currentIndex++;
                }
                else
                {
                    length = lps[length-1];
                }
            }
        }
        return lps;
    }
}