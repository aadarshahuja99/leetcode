class Solution {
    public int strStr(String s, String t) {
        // KMP
        int[] lps = getLPS(t);
        int i=0;
        int j=0;
        while(i < s.length())
        {
            if(s.charAt(i) == t.charAt(j))
            {
                i++;
                j++;
                if(j == t.length())
                {
                    return i - j;
                }
            }
            else if(j > 0)
            {
                j = lps[j-1];
            }
            else
            {
                i++;
            }
        }
        return -1;
    }
    private int[] getLPS(String s)
    {
        int[] lps = new int[s.length()];
        int j=0;
        int i=1;
        while(i < s.length())
        {
            if(s.charAt(i) == s.charAt(j))
            {
                lps[i] = j+1;
                i++;
                j++;
            }
            else if(j == 0)
            {
                i++;
            }
            else
            {
                j = lps[j-1];
            }
        }
        return lps;
    }
}