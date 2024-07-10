class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        TreeMap<Integer,Integer> set = new TreeMap<>();
        for(int num : nums)
        {
            set.put(num, set.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for(int num : set.keySet())
        {
            var floor = set.lowerEntry(k - num);
            int val = 0;
            if(floor != null)
            {
                if((floor.getKey() == num && floor.getValue() > 1) || floor.getKey() != num)
                {
                    val = floor.getKey();
                }
            }
            if(val == 0)
            {
                continue;
            }
            // System.out.println(num+" "+val);
            max = Math.max(num+val, max);
        }
        return max == 0 ? -1 : max;
    }
}