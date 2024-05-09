class Solution {
    public boolean canBeValid(String s, String locked) {
        int openings = 0;
        int closings = 0;
        int n = s.length();
        if(n%2 == 1)
        {
            return false;
        }
        for(int i=0; i<n; i++)
        {
            char c = s.charAt(i);
            if(c == '(' || locked.charAt(i) == '0')
            {
                openings++;
            }
            else
            {
                closings++;
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
            if(c == ')' || locked.charAt(i) == '0')
            {
                closings++;
            }
            else
            {
                openings++;
            }
            if(openings > closings)
            {
                return false;
            }
        }
        return true;
    }
}