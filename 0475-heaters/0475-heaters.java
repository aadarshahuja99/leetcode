class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int numHouses = houses.length;
        int start = 0;
        int end = Math.max(houses[numHouses - 1] - houses[0] + 1, heaters[heaters.length - 1]);
        int ans = 0;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(check(mid,heaters,houses))
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int current, int[] heaters, int[] houses)
    {
        int houseIndex = 0;
        int heaterIndex = 0;
        while(houseIndex < houses.length && heaterIndex < heaters.length)
        {
            if(houses[houseIndex] >= heaters[heaterIndex] - current && houses[houseIndex] <= heaters[heaterIndex] + current)
            {
                houseIndex++;
            }
            else if(houses[houseIndex] < heaters[heaterIndex] - current)
            {
                return false;
            }
            else
            {
                heaterIndex++;
            }
        }
        if(houseIndex == houses.length)
        {
            return true;
        }
        return false;
    }
}