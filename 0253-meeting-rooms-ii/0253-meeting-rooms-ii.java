class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for(int[] interval : intervals)
        {
            max = Math.max(max, interval[1]);
        }
        int[] hash = new int[max+2];
        for(int[] interval : intervals)
        {
            hash[interval[0]]++;
            hash[interval[1]]--;
        }
        int total = 0;
        int ans = 0;
        for(int i=0; i<hash.length; i++)
        {
            total += hash[i];
            ans = Math.max(ans, total);
        }
        return ans;
    }
}