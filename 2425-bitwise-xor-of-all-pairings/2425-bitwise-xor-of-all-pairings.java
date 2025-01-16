class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        HashMap<Integer,Integer> combined = new HashMap<>();
        for(int num : nums1)
        {
            map1.put(num, map1.getOrDefault(num,0) + 1);
        }

        for(int num : nums2)
        {
            map2.put(num, map2.getOrDefault(num,0) + 1);
        }

        for(int num : map1.keySet())
        {
            combined.put(num, map1.get(num)*(nums2.length - map2.getOrDefault(num, 0)));
        }

        int ans = 0;
        for(int num : map2.keySet())
        {
            combined.put(num, combined.getOrDefault(num, 0) + map2.get(num)*(nums1.length - map1.getOrDefault(num, 0)));
            // System.out.println(num+" "+combined.get(num));
            if(combined.get(num)%2 == 1)
            {
                ans = (ans^num);
            }
        }
        return ans;
    }
}