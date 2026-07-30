class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) xor = (xor^num);
        int num1 = 0;
        int num2 = 0;
        int xor1 = ((xor)&(-xor));
        for(int num : nums)
        {
            if((num&xor1) != 0)
            {
                num1 = (num1^num);
            }
        }
        num2 = xor^num1;
        return new int[] { num1, num2 };
    }
}