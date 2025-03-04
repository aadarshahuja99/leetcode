class Solution {
    public boolean checkPowersOfThree(int n) {
        if(n%3 == 2)
        {
            return false;
        }
        int[] bits = new int[16];
        int idx = 0;
        while(n > 0)
        {
            bits[idx] = n%3;
            if(bits[idx] == 2)
            {
                return false;
            }
            n = n/3;
            idx++;
        }
        return true;
    }
}