class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0);
        long absDividend = Math.abs(1l*dividend);
        long absDivisor = Math.abs(1l*divisor);
        int pow = -1;
        while((absDivisor*(1l<<(pow+1))) <= absDividend)
        {
            pow++;
        }
        long ans = 0;
        // System.out.println(pow);
        while(pow >= 0)
        {
            if(absDividend >= (absDivisor*(1l<<pow)))
            {
                absDividend -= (absDivisor*(1l<<pow));
                ans = (ans|(1l<<pow));
            }
            pow--;
        }
        return isNegative ? (int)Math.max(Integer.MIN_VALUE, -1l*ans) : (int)Math.min(Integer.MAX_VALUE, ans);
    }
}