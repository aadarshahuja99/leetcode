class Solution {
    public boolean increasingTriplet(int[] nums) {
        // a less optimized solution would have been to involve LIS and check if an LIS of length three is present in the array. TC would have been nlogn with n extra space
        // greedy solution
        // consider the example: [2,3,0,1,4], [10,9,11,15]
        int minSoFar = Integer.MAX_VALUE;
        int secondMinSoFar = Integer.MAX_VALUE;
        for(int num : nums)
        {
            if(minSoFar >= num)
            {
                minSoFar = num;
            }
            else if(secondMinSoFar >= num)
            {
                secondMinSoFar = num;
            }
            else
            {
                // we reached a case where there are two numbers that are smaller than the current number and appear before it. The if.. else if above this else ensures a sequence is maintained for LIS of length 2: [2,3,0,4]
                return true;
            }
        }
        return false;
    }
}