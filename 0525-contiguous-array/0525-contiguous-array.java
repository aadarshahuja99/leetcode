class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int ans = 0;
        int idx = 0;
        for(int num : nums)
        {
            if(num == 0)
            {
                sum--;
            }
            else
            {
                sum++;
            }
            if(sum == 0)
            {
                ans = Math.max(ans, idx-map.get(0));
            }
            if(!map.containsKey(sum))
            {
                map.put(sum, idx);
            }
            else
            {
                ans = Math.max(ans, idx - map.get(sum));
            }
            idx++;
        }
        return ans;
    }
}