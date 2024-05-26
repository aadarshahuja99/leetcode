class Solution {
    public void rotate(int[] nums, int k) {
        // striver's optimal idea
        int n = nums.length;
        if(n == 1)
        {
            return;
        }
        int rotations = k%n;
        if(rotations == 0)
        {
            return;
        }
        int secondSegmentStart = n - rotations;
        int secondSegmentEnd = n-1;
        while(secondSegmentStart < secondSegmentEnd)
        {
            int temp = nums[secondSegmentStart];
            nums[secondSegmentStart] = nums[secondSegmentEnd];
            nums[secondSegmentEnd] = temp;
            secondSegmentStart++;
            secondSegmentEnd--;
        }
        int firstSegmentStart = 0;
        int firstSegmentEnd = n - rotations - 1;
        while(firstSegmentStart < firstSegmentEnd)
        {
            int temp = nums[firstSegmentStart];
            nums[firstSegmentStart] = nums[firstSegmentEnd];
            nums[firstSegmentEnd] = temp;
            firstSegmentStart++;
            firstSegmentEnd--;
        }
        int start = 0;
        int end = n-1;
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}