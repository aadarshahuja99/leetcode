class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ast : asteroids)
        {
            if(st.size() == 0)
            {
                st.push(ast);
            }
            else
            {
                if(st.peek() > 0 && ast < 0)
                {
                    while(st.size() > 0 && st.peek() > 0 && Math.abs(ast) > st.peek())
                    {
                        st.pop();
                    }
                    if(st.size() == 0 || st.peek() < 0)
                    {
                        st.push(ast);
                    }
                    else if(st.peek() == Math.abs(ast))
                    {
                        st.pop();
                    }
                }
                else
                {
                    st.push(ast);
                }
            }
        }
        int[] ans = new int[st.size()];
        int idx = 0;
        while(!st.isEmpty())
        {
            ans[idx] = st.pop();
            idx++;
        }
        for(int i=0; i<ans.length/2; i++)
        {
            int temp = ans[i];
            ans[i] = ans[ans.length-i-1];
            ans[ans.length-i-1] = temp;
        }
        return ans;
    }
}