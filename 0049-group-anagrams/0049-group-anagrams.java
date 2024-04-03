class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> visited = new HashMap<>();
        for(String str : strs)
        {
            String hash = getHash(str);
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
    private String getHash(String str)
    {
        int[] letterCounts = new int[26];
        String hash = "";
        for(char c : str.toCharArray())
        {
            int letterIndex = c - 97;
            letterCounts[letterIndex]++;
        }
        for(int i=0; i<26; i++)
        {
            hash += letterCounts[i] + "$";
        }
        return hash;
    }
}