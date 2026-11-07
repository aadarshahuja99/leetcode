class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // in-place hashing. Very similar to find all duplicates. Intuition: check for the presence of all numbers in the range of 1 to N.
        // check whether number k is present in the array and is at the k-1th index or not. If the 2nd condition is not true, then swap
        int j=0;
        while(j < n)
        {
            int idx = nums[j]-1;
            // Intuition:
            // if the current element is in the range of [1,n] then it must be moved to its correct index i.e. nums[j] - 1, else skip the current element with j++
            if(nums[j] > 0 && nums[j] <=n && nums[idx] != nums[j])
            {
                int temp = nums[idx];
                nums[idx] = nums[j];
                nums[j] = temp;
            }
            else
            {
                j++;
            }
        }
        for(int i=0; i<n; i++)
        {
            if(nums[i] != i+1)
            {
                return i+1;
            }
        }
        // this handles the case when all the elements in the array are from 1 to n and are unique
        return n+1;
    }
}