class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // line sweep revision
        int[] hash = new int[n+2];
        for(int[] booking : bookings)
        {
            hash[booking[0]] += booking[2];
            hash[booking[1]+1] -= booking[2];
        }
        int[] ans = new int[n];
        int sum = 0;
        for(int i=1; i<=n; i++)
        {
            sum += hash[i];
            ans[i-1] = sum;
        }
        return ans;
    }
}