class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        Long absDividend = Math.abs((long)dividend);
        Long absDivisor = Math.abs((long)divisor);
        int ans = 0; // quotient
        while(absDividend >= absDivisor)
        {
            Long tempDivisor = absDivisor;
            int multiple = 1;
            while(absDividend >= (tempDivisor<<1))
            {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            absDividend -= tempDivisor;
            ans += multiple;
        } 
        return isNegative ? -ans : ans;
    }
}