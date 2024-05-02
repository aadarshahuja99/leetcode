class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] status = new boolean[s.length()];
        for(String word : words)
        {
            searchUsingKMP(s, word, status);
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < s.length())
        {
            if(status[idx])
            {
                sb.append("<b>");
                while(idx < s.length() && status[idx])
                {
                    sb.append(s.charAt(idx));
                    idx++;
                }
                sb.append("</b>");
            }
            else
            {
                sb.append(s.charAt(idx));
                idx++;
            }
        }
        return sb.toString();
    }
    private void searchUsingKMP(String s, String word, boolean[] status)
    {
        int[] lps = findLPS(word);
        int i=0;
        int j=0;
        int n=s.length();
        int m=word.length();
        while(i < n && j < m)
        {
            if(s.charAt(i) == word.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if(j == 0)
                {
                    i++;
                }
                else
                {
                    j = lps[j-1];
                }
            }
            if(j == m)
            {
                // System.out.println(i+" "+j+" "+word);
                for(int k=i-m; k<i; k++)
                {
                    status[k] = true;
                }
                j = lps[j-1];
            }
        }
    }
    private int[] findLPS(String word)
    {
        int n = word.length();
        int[] lps = new int[n];
        int j=0;
        int i=1;
        while(i < n)
        {
            if(word.charAt(i) == word.charAt(j))
            {
                lps[i] = j + 1;
                i++;
                j++;
            }
            else
            {
                if(j == 0)
                {
                    i++;
                }
                else
                {
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }
}