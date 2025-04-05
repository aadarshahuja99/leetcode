class Solution {
    public boolean increasingTriplet(int[] nums) {
        // a less optimized solution would have been to involve LIS and check if an LIS of length three is present in the array. TC would have been nlogn with n extra space
        // greedy solution
        int thirdMaxSoFar = Integer.MAX_VALUE;
        int secondMaxSoFar = Integer.MAX_VALUE;
        for(int num : nums)
        {
            if(thirdMaxSoFar >= num)
            {
                thirdMaxSoFar = num;
            }
            else if(secondMaxSoFar >= num)
            {
                secondMaxSoFar = num;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}