class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int bill : bills)
        {
            if(bill == 5)
            {
                fives++;
            }
            else if(bill == 10)
            {
                if(fives > 0)
                {
                    fives--;
                }
                else
                {
                    return false;
                }
                tens++;
            }
            else
            {
                if(fives == 0)
                {
                    return false;
                }
                if(fives < 3 && tens == 0)
                {
                    return false;
                }
                if(tens == 0)
                {
                    fives -= 3;
                }
                else
                {
                    fives -= 1;
                    tens -= 1;
                }
            }
        }
        return true;
    }
}