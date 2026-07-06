class Solution {
    public int totalFruit(int[] fruits) {
        int numTrees = fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int ans = 0;
        while(j < numTrees)
        {
            // consume the jth guy
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            j++;
            // if the window became invalid, then shrink it to find the longest possible valid window ending at the last consumed guy
            while(map.size() > 2)
            {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) == 0)
                {
                    map.remove(fruits[i]);
                }
                i++;
            }
            // compute ans
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}