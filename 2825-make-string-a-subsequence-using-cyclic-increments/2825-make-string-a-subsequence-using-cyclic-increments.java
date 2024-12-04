class Solution {
    public boolean canMakeSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i=0; 
        int j=0;
        while(i < n && j < m)
        {
            if(s1.charAt(i) == s2.charAt(j) || ((s2.charAt(j) - s1.charAt(i)) == 1) || (s2.charAt(j) == 'a' && s1.charAt(i) == 'z'))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        return j==m;
    }
}