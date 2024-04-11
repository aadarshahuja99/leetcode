class Solution {
    public int totalFruit(int[] fruits) {
        int numTrees = fruits.length;
        HashMap<Integer,Integer> uniqueFruitTypes = new HashMap<>();
        int i=0;
        int j=0;
        int ans = 0;
        while(j < numTrees)
        {
            if(uniqueFruitTypes.size() <= 2)
            {
                uniqueFruitTypes.put(fruits[j], uniqueFruitTypes.getOrDefault(fruits[j],0) + 1);
                j++;
            }
            else
            {
                ans = Math.max(ans, j-i-1);
                while(uniqueFruitTypes.size() > 2)
                {
                    uniqueFruitTypes.put(fruits[i], uniqueFruitTypes.get(fruits[i]) - 1);
                    if(uniqueFruitTypes.get(fruits[i]) == 0)
                    {
                        uniqueFruitTypes.remove(fruits[i]);
                    }
                    i++;
                }
            }
        }
        if(uniqueFruitTypes.size() <= 2)
        {
            ans = Math.max(ans, j-i);
        }
        else
        {
            ans = Math.max(ans, j-i-1);
        }
        return ans;
    }
}