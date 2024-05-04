class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] buckets = new int[1000002];
        for(int[] interval : intervals)
        {
            buckets[interval[0]]++;
            buckets[interval[1]]--;
        }

        int runningSum = 0;
        int maxRoomsAtAnyInstant = 0;
        for(int num : buckets)
        {
            runningSum += num;
            maxRoomsAtAnyInstant = Math.max(maxRoomsAtAnyInstant, runningSum);
        }
        return maxRoomsAtAnyInstant;
    }
}