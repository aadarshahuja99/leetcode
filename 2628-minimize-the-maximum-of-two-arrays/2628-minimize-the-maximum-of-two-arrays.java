class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        long lcm = getLCM(divisor1, divisor2);
        // System.out.println(lcm);
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            // System.out.println("current mid " + mid + " s: "+start+" e: "+end);
            if(check(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2, lcm))
            {
                ans = mid;
                end = mid-1;
                // System.out.println(" new end : "+end);
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int d1, int d2, int u1, int u2, long lcm)
    {
        // the check function here will return whether the max value lies to the left of the current guess
        // i.e max <= guess
        // if yes, we move left to find the smallest such guess
        // else we move right
        int divisbleBy1 = guess/d1;
        int divisbleBy2 = guess/d2;
        long commonMultiples = 1l*guess/lcm;
        // System.out.println((guess - divisbleBy1 - divisbleBy2 + commonMultiples)+", "+(guess - divisbleBy1)+", "+(guess - divisbleBy2)+" "+commonMultiples);
        if((guess - divisbleBy1) >= u1 && (guess - divisbleBy2) >= u2 && (guess - commonMultiples) >= (u1 + u2))
        {
            // System.out.println("true for "+guess);
            return true;
        }
        // System.out.println("false for "+guess);
        return false;
    }
    private long getLCM(int a, int b)
    {
        long ans = 1l*a*b;
        int hcf = getHCF(Math.max(a, b), Math.min(a, b));
        return ans/hcf;
    }
    private int getHCF(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return getHCF(b, a%b);
    }
}