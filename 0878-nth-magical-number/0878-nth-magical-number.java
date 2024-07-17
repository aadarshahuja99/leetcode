class Solution {
    int MOD = 1_000_000_007;
    public int nthMagicalNumber(int n, int a, int b) {
        int hcf = gcd(a,b);
        long lcm = 1l*a*b/hcf;
        long low = 1;
        int ans = 0;
        long high = 1l*n*Math.min(a,b);
        while(low <= high)
        {
            long mid = low + (high - low)/2;
            if(check(mid, a, b, lcm, n))
            {
                ans = (int)(mid%MOD);
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean check(long guess, int a, int b, long lcm, int n)
    {
        long count = guess/a + guess/b - guess/lcm;
        return count >= n;
    }
    private int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return gcd(b, a%b);
    }
}