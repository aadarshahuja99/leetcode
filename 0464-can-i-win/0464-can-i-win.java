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
        return getAns(0, 0, max, desired, new Boolean[1<<(max)]);
    }
    private boolean getAns(int state, int total, int max, int desired, Boolean[] cache)
    {
        int selections = Integer.bitCount(state);
        int isFirstPlayer = 0;
        if(selections%2 == 0)
        {
            isFirstPlayer = 1;
        }
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
                    ans = ans | getAns(state|(1<<i), total + i + 1, max, desired, cache);
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
                    ans = ans && getAns(state|(1<<i), total + i + 1, max, desired, cache);
                }
            }
        }
        return cache[state] = ans;
    }
}