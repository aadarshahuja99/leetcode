class Solution {
    public int minAddToMakeValid(String s) {
        int closing = 0;
        int opening = 0;
        int ans = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                opening++;
            }
            else
            {
                closing++;
            }
            if(closing == opening+1)
            {
                opening++;
                ans++;
            }
        }
        if(opening > closing)
        {
            return opening - closing + ans;
        }
        return ans;
    }
}