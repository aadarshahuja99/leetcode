class Solution {
    public int minimizeXor(int num1, int num2) {
        // greedy, find out the number of set bits for num2
        if(num2 == 0)
        {
            return 0;
        }
        int[] num2Bits = new int[32];
        int[] num1Bits = new int[32];
        int count = 0;
        int i = 31;
        while(i >= 0)
        {
            if((num2&(1<<i)) > 0)
            {
                num2Bits[i] = 1;
                count++;
            }
            if((num1&(1<<i)) > 0)
            {
                num1Bits[i] = 1;
            }
            i--;
        }
        if(count == 32)
        {
            return Integer.MAX_VALUE;
        }
        i = 31;
        int ans = 0;
        while(i >= 0)
        {
            if(num1Bits[i] == 1 && count > 0)
            {
                ans = (ans|(1<<i));
                count--;
            }
            i--;
        }
        // after the most significant set bits of num1 have been set in answer and still some more bits are yet to be set, set the least unset significant ones to 1 to minimize the value
        if(count > 0)
        {
            i = 0;
            while(count > 0)
            {
                if((ans&(1<<i)) == 0)
                {
                    ans = (ans|(1<<i));
                    count--;
                }
                i++;
            }
        }
        return ans;
    }
}