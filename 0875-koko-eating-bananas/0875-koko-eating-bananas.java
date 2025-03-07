class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 0;
        int e = Integer.MAX_VALUE;
        int ans = 0;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(check(m, piles, h))
            {
                ans = m;
                e = m-1;
            }
            else
            {
                s = m+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[] piles, int h)
    {
        int total = 0;
        for(int p : piles)
        {
            int val = (int)Math.ceil((double)p/(1.0*guess));
            total += val;
            if(total > h)
            {
                return false;
            }
        }
        return true;
    }
}