class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // a,b,c can have common multiples. If counted, these common multiples will result in incorrect ans.
        // Use the INCLUSION - EXCLUSION principle + binary search since we can not traverse from 0 to n-1
        long lcmAB = 1L*a*b/(computeHCF(a,b)); // since num1*num2 = lcm(num1, num2)*hcf(num1, num2)
        long lcmBC = 1L*c*b/(computeHCF(b,c));
        long lcmAC = 1L*a*c/(computeHCF(a,c));
        long lcmABC = 1L*lcmBC*a/(computeHCF((int)lcmBC, a));
        long start = 0;
        System.out.println(lcmAB + " " + lcmBC + " " + lcmAC + " " + lcmABC); 
        long end = 2*1000000000;
        long ans = -1;
        while(start <= end)
        {
            long mid = start + (end - start)/2;
            if(check(mid, a, b, c, lcmAB, lcmBC, lcmAC, lcmABC, n))
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return (int)ans;
    }
    private boolean check(long guess, int a, int b, int c, long lcmAB, long lcmBC, long lcmAC, long lcmABC, int n)
    {
        long count = (guess)/a + (guess)/b + (guess)/c - (guess/lcmAB) - ((guess)/lcmBC) - ((guess)/lcmAC) + ((guess)/lcmABC);
        // System.out.println(guess+" "+count);
        return count >= (long)n;
    }
    private int computeHCF(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return computeHCF(b, a%b);
    }
}