class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int nonAffectedRows = 2*n;
        int ans = nonAffectedRows;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] res : reservedSeats)
        {
            int row = res[0];
            int col = res[1];
            map.put(row, (map.getOrDefault(row, 0)|(1<<(col-1))));
        }
        ans -= 2*map.size();
        int maskForMiddleSeats = 120;
        int maskForLeftSeats = 480;
        int maskForRightSeats = 30;
        for(int val : map.values())
        {
            if(((val&maskForLeftSeats) == 0) && ((val&maskForRightSeats) == 0))
            {
                ans += 2;
            }
            else if((val&maskForMiddleSeats) == 0)
            {
                ans++;
            }
            else if(((val&maskForLeftSeats) == 0) || ((val&maskForRightSeats) == 0))
            {
                ans++;
            }
        }
        return ans;
    }
}