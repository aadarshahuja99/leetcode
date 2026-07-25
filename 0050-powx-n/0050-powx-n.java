class Solution {
    public double myPow(double x, int n) {
        return helper(x, 1l*n);
    }
    private double helper(double x, long n)
    {
        if(n == 1)
        {
            return x;
        }
        if(n == 0) return 1.0;
        if(n < 0) return helper(1.0/x, -1*n);
        double recursiveAns = helper(x,n/2);
        if(n%2 == 0)
        {
            return recursiveAns*recursiveAns;
        }
        return x*recursiveAns*recursiveAns;
    }
}