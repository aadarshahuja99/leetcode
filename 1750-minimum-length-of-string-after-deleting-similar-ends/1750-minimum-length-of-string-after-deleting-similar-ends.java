class Solution {
    public int minimumLength(String s) {
        if(s.length() == 1)
        {
            return 1;
        }
        int i = 0;
        int j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return j-i+1;
            }
            char c = s.charAt(i);
            while(i<=j && s.charAt(i) == c)
            {
                i++;
            }
            while(j>i && s.charAt(j) == c)
            {
                j--;
            }
        }
        return j-i+1;
    }
}