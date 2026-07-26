class Solution {
    public int majorityElement(int[] nums) {
        int el = Integer.MIN_VALUE;
        int c = 0;
        for(int num : nums)
        {
            if(c == 0)
            {
                c = 1;
                el = num;
            }
            else if(el == num)
            {
                c++;
            }
            else
            {
                c--;
            }
        }
        int count = 0;
        for(int num : nums)
        {
            if(el == num) count++;
        }
        if(count > nums.length/2)
        {
            return el;
        }
        return -1;
    }
}