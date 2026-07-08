class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0;
        int pointer = 0;
        // i represents the start of a new set of duplicate elements with unique value nums[i]
        while(i < n)
        {
            int j=i+1;
            while(j < n && nums[j] == nums[i])
            {
                j++;
            }
            int temp = nums[pointer];
            nums[pointer] = nums[i];
            nums[i] = temp;
            pointer++;
            i=j;
        }
        return pointer;
    }
}