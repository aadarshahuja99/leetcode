class Solution {
    int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] next = new int[n];
        int[] prev = new int[n];
        
        // next smaller
        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && nums[i] <= nums[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                next[i] = n;
            }
            else
            {
                next[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        // prev smaller
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && nums[i] < nums[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                prev[i] = -1;
            }
            else
            {
                prev[i] = st.peek();
            }
            st.push(i);
        }
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            long greaterBefore = i - prev[i] - 1;
            long greaterAfter = next[i] - i - 1;
            ans = (ans%MOD + (int)(((greaterBefore+1)*(greaterAfter+1)*(1l*nums[i]))%MOD))%MOD;
        }
        return ans;
    }
}