class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int[] flower : flowers)
        {
            map.put(flower[0], map.getOrDefault(flower[0],0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1,0) - 1);
        }
        int total = 0;
        for(int key : map.keySet())
        {
            total += map.get(key);
            map.put(key, total);
        }
        int[] ans = new int[people.length];
        int idx = 0;
        for(int person : people)
        {
            var floor = map.floorEntry(person);
            if(floor == null || floor.getValue() == 0)
            {
                ans[idx] = 0;
                idx++;
            }
            else
            {
                ans[idx] = floor.getValue();
                idx++;
            }
        }
        return ans;
    }
}