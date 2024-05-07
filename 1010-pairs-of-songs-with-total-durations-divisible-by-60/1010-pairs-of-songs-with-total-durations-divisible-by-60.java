class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : time)
        {
            if(map.containsKey((60 - (num%60))%60))
            {
                ans += map.get((60 - (num%60))%60);
                // System.out.println(num);
            }
            map.put((num%60), map.getOrDefault((num%60), 0) + 1);
        }
        return ans;
    }
}