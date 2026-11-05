class Solution {
    int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] next = new int[n];
        // next smaller
        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && nums[i] <= nums[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                next[i] = n-1;
            }
            else
            {
                next[i] = st.peek()-1;
            }
            st.push(i);
        }
        st.clear();
        // prev smaller
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            int prev = 0;
            while(!st.isEmpty() && nums[i] < nums[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                prev = 0;
            }
            else
            {
                prev = st.peek()+1;
            }
            // compute the answer
            int lengthBefore = i - prev;
            int lengthAfter = next[i] - i;
            ans = (ans%MOD + (int)((1l*(lengthBefore+1)*nums[i]*(lengthAfter+1))%MOD))%MOD;
            st.push(i);
        }
        return ans;
    }
}