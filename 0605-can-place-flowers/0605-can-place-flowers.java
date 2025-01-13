class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length;)
        {
            if(flowerbed[i] == 1)
            {
                i += 2;
                continue;
            }
            if(flowerbed[i] == 0)
            {
                if(i+1 == flowerbed.length || flowerbed[i+1] == 0)
                {
                    n--;
                    i += 2;
                }
                else
                {
                    i += 3;
                }
            }
        }
        return n <= 0;
    }
}