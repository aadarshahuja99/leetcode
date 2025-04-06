class Solution {
    private static int HALF_INT_MIN = -1073741824; // -2**30;

    public int divide(int dividend, int divisor) {
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        Long absDividend = Math.abs((long)dividend);
        Long absDivisor = Math.abs((long)divisor);
        int ans = 0;
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