class Solution {
    public int countTriplets(int[] nums) {
        // based on vlad's solution
        int size = (int)Math.pow(2, 16);
        int[] map = new int[size];
        for(int a : nums)
        {
            for(int b : nums)
            {
                map[a&b]++;
            }
        }
        int ans = 0;
        for(int a : nums)
        {
            for(int k =0; k<map.length; k++)
            {
                if((k&a) == 0)
                {
                    ans += map[k];
                }
            }
        }
        return ans;
    }
}