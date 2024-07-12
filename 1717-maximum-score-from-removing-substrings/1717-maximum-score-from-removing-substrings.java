class Solution {
    public int maximumGain(String s, int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        Stack<Character> st = new Stack<>();
        int ans = 0;
        // max loop
        for(char c : s.toCharArray())
        {
            if(c == 'a')
            {
                if(!st.isEmpty() && st.peek() == 'b' && max == y)
                {
                    st.pop();
                    ans += y;
                }
                else
                {
                    st.push(c);
                }
            }
            else if(c == 'b')
            {
                if(!st.isEmpty() && st.peek() == 'a' && max == x)
                {
                    st.pop();
                    ans += x;
                }
                else
                {
                    st.push(c);
                }
            }
            else
            {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        String current = sb.reverse().toString();
        // min loop
        for(char c : current.toCharArray())
        {
            if(c == 'a')
            {
                if(!st.isEmpty() && st.peek() == 'b' && min == y)
                {
                    st.pop();
                    ans += y;
                }
                else
                {
                    st.push(c);
                }
            }
            else if(c == 'b')
            {
                if(!st.isEmpty() && st.peek() == 'a' && min == x)
                {
                    st.pop();
                    ans += x;
                }
                else
                {
                    st.push(c);
                }
            }
            else
            {
                st.push(c);
            }
        }
        return ans;
    }
}