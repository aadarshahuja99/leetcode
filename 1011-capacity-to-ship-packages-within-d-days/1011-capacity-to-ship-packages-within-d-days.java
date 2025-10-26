class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = Integer.MIN_VALUE;
        int e = 0;
        for(int w : weights)
        {
            e += w;
            s = Math.max(w, s);
        }
        int ans = 0;
        while(s <= e)
        {
            int guess = s + (e-s)/2;
            if(check(guess, weights, days))
            {
                ans = guess;
                e = guess-1;
            }
            else
            {
                s = guess+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[] weights, int days)
    {
        int n = weights.length;
        int index = 0;
        int d = 0;
        while(index < n)
        {
            int total = 0;
            int s = weights[index];
            int j = index+1;
            while(j < n && weights[j] + s <= guess)
            {
                s += weights[j];
                j++;
            }
            d++;
            index = j;
        }
        return d <= days;
    }
}