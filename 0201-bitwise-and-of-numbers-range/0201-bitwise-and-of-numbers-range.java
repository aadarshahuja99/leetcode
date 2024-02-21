class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left == right)
        {
            return left;
        }
        int ans = 0;
        while(left > 0 && right > 0)
        {
            int nextLeft = (int)Math.floor(Math.log(left)/Math.log(2));
            int nextRight = (int)Math.floor(Math.log(right)/Math.log(2));
            if(nextLeft != nextRight)
            {
                return ans;
            }
            ans += (int)Math.pow(2,nextLeft);
            left -= (int)Math.pow(2,nextLeft);
            right -= (int)Math.pow(2,nextRight);
        }
        return ans;
    }
}