class Solution {
    public int getLargestOutlier(int[] nums) {
        // math question: the sum apart from the outlier must be an even number and the (rem sum)/2 value should be an element in the array
        HashMap<Integer, Integer> set = new HashMap<>();
        int total = 0;
        for(int num : nums)
        {
            total += num;
            set.put(num, set.getOrDefault(num,0) + 1);
        }
        // System.out.println(total);
        int ans = Integer.MIN_VALUE;
        for(int num : set.keySet())
        {
            int rem = total - num;
            if(Math.abs(rem)%2 == 0)
            {
                // System.out.println(num+" "+(rem/2)+" "+num+" "+(set.getOrDefault(rem/2, 0)));
                if(((rem/2) == num && set.getOrDefault(rem/2, 0) >= 2))
                {
                    ans = Math.max(ans, num);
                }
                else if((rem/2) != num && set.containsKey(rem/2))
                {
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }
}