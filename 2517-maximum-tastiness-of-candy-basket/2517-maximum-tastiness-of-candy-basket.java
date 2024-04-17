class Solution {
    public int maximumTastiness(int[] price, int k) {
        // binary search on ans
        Arrays.sort(price);
        int start = 0;
        int end = price[price.length-1] - price[0];
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(check(mid, price, k))
            {
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[] price, int k)
    {
        int numPrices = price.length;
        int candies = 1;
        int previousPrice = price[0];
        for(int i=1; i<numPrices; i++)
        {
            if(price[i] - previousPrice >= guess)
            {
                candies++;
                if(candies == k)
                {
                    return true;
                }
                previousPrice = price[i];
            }
        }
        return false;
    }
}