class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, ArrayList<String>> visited = new HashMap<>();
        for(String str : strs)
        {
            Integer hash = getHash(str);
            if(!visited.containsKey(hash))
            {
                ArrayList<String> group = new ArrayList<>();
                group.add(str);
                visited.put(hash, group);
            }
            else
            {
                visited.get(hash).add(str);
            }
        }
        ArrayList<List<String>> ans = new ArrayList<>();
        for(var entry : visited.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
    private Integer getHash(String str)
    {
        int[] letterCounts = new int[26];
        for(char c : str.toCharArray())
        {
            int letterIndex = c - 97;
            letterCounts[letterIndex]++;
        }
        return Arrays.hashCode(letterCounts);
    }
}