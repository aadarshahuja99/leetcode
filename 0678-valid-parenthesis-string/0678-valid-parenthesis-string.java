class Solution {
    public boolean checkValidString(String s) {
        int openings = 0;
        int closings = 0;
        int stars = 0;
        int n = s.length();
        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                openings++;
            }
            else if(c == ')')
            {
                closings++;
            }
            else
            {
                stars++;
            }
            if(closings > openings + stars)
            {
                return false;
            }
        }
        openings = 0;
        closings = 0;
        stars = 0;
        for(int i=n-1; i>=0; i--)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                openings++;
            }
            else if(c == ')')
            {
                closings++;
            }
            else
            {
                stars++;
            }
            if(openings > closings + stars)
            {
                return false;
            }
        }
        return true;
    }
}