import java.math.BigInteger;
class Solution {
    public int uniquePaths(int m, int n) {
        return getNCR(m+n-2, m-1);
    }
    // combinatorics
    private int getNCR(int n, int r)
    {
        BigInteger numerator = BigInteger.valueOf(1);
        BigInteger denomenator = BigInteger.valueOf(1);
        for(int i=0; i<r; i++)
        {
            numerator = numerator.multiply(BigInteger.valueOf(n-i));
            denomenator = denomenator.multiply(BigInteger.valueOf(i+1));
        }
        return (numerator.divide(denomenator)).intValue();
    }
}