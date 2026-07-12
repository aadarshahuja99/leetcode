class Solution {
    public boolean canIWin(int max, int desired) {
        if(max*(max+1)/2 < desired)
        {
            return false;
        }
        if(desired == 0)
        {
            return true;
        }
        return getAns(1, 0, max, 0, desired, new Boolean[1<<(max)]);
    }
    private boolean getAns(int isFirstPlayer, int state, int max, int total, int desired, Boolean[] cache)
    {
        if(total >= desired)
        {
            return isFirstPlayer == 0;
        }
        if(cache[state] != null)
        {
            return cache[state];
        }
        boolean ans = false;
        if(isFirstPlayer == 1)
        {
            for(int i=0; i<max; i++)
            {
                if((state&(1<<i)) == 0)
                {
                    ans = ans | getAns(0, state|(1<<i), max, total + i + 1, desired, cache);
                }
            }
        }
        else
        {
            ans = true;
            for(int i=0; i<max; i++)
            {
                if((state&(1<<i)) == 0)
                {
                    ans = ans && getAns(1, state|(1<<i), max, total + i + 1, desired, cache);
                }
            }
        }
        return cache[state] = ans;
    }
}