class Solution {
    public boolean increasingTriplet(int[] nums) {
        // a less optimized solution would have been to involve LIS and check if an LIS of length three is present in the array. TC would have been nlogn with n extra space
        // greedy solution
        // consider the example: [2,3,0,1,4]
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
                return true;
            }
        }
        return false;
    }
}