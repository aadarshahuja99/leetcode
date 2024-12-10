class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n==1)
        {
            return 1;
        }
        int[] candies = new int[n];
        candies[0] = ratings[0] > ratings[1] ? 2 : 1;
        for(int i=1; i<n; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                candies[i] = 1+candies[i-1];
            }
            else
            {
                candies[i] = 1;
            }
        }

        int sum = candies[n-1];
        for(int i=n-2; i>=0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                candies[i] = Math.max(1+candies[i+1], candies[i]);
            }
            sum += candies[i];
        }
        return sum;
    }
}