class Solution {
    public boolean checkValidString(String s) {
        int openings = 0;
        int closings = 0;
        int n = s.length();
        for(char c : s.toCharArray())
        {
            if(c == ')')
            {
                closings++;
            }
            else
            {
                openings++;
            }
            if(closings > openings)
            {
                return false;
            }
        }
        openings = 0;
        closings = 0;
        for(int i=n-1; i>=0; i--)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                openings++;
            }
            else
            {
                closings++;
            }
            if(openings > closings)
            {
                return false;
            }
        }
        return true;
    }
}