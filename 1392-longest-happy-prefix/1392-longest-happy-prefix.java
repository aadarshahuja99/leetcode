class Solution {
    public String longestPrefix(String s) {
        if(s.length() == 1)
        {
            return "";
        }
        int i=1;
        int prev=0;
        int[] lps = new int[s.length()];
        while(i<s.length())
        {
            if(s.charAt(i) == s.charAt(prev))
            {
                lps[i] = prev + 1; // if there is a match, set the current longest prefix match length to prev plus 1.
                i++;
                prev++;
            }
            else if(prev == 0)
            {
                i++;
            }
            else
            {
                prev = lps[prev-1];
            }
        }
        if(lps[s.length()-1] == 0)
        {
            return "";
        }
        return s.substring(0,lps[s.length()-1]);
    }
}