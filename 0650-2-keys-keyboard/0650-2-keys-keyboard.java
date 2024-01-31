class Solution {
    int max = 1001;
    public int minSteps(int n) {
        return getAns(1,0,n);
    }
    private int getAns(int current, int lastLength, int n)
    {
        if(current == n)
        {
            return 0;
        }
        if(lastLength == 0)
        {
            return 1 + getAns(current,1,n);
        }
        if(lastLength + current <= n)
        {
            if(lastLength != current)
            {
                return 1 + Math.min(getAns(current+lastLength,lastLength,n), getAns(current,current,n));
            }
            return 1 + getAns(current+lastLength,lastLength,n);
        }
        // if no further operations can be done to get to n, return max val indicating that it is not possible to get to n.
        return max;
    }
}