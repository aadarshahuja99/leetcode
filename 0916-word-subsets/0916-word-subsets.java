class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        int m = words2.length;
        HashMap<Character,Integer>[] countMaps = new HashMap[n];
        HashMap<Character,Integer> countMap2 = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            countMaps[i] = new HashMap<>();
            for(char ch : words1[i].toCharArray())
            {
                countMaps[i].put(ch, countMaps[i].getOrDefault(ch, 0) + 1);
            }
        }
        for(int i=0; i<m; i++)
        {
            for(char ch : words2[i].toCharArray())
            {
                countMap2.put(ch, countMap2.getOrDefault(ch, 0) + 1);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            boolean isValid = true;
            for(char ch : countMap2.keySet())
            {
                if(!countMaps[i].containsKey(ch) || countMaps[i].get(ch) < countMap2.get(ch))
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
            {
                ans.add(words1[i]);
            }
        }
        return ans;
    }
}