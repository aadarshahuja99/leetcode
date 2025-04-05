class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s : strs)
        {
            var enc = encode(s);
            if(!map.containsKey(enc))
            {
                map.put(enc, new ArrayList<>());
            }
            map.get(enc).add(s);
        }
        ArrayList<List<String>> ans = new ArrayList<>();
        for(var entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
    private String encode(String s)
    {
        int[] counts = new int[26];
        for(char c : s.toCharArray())
        {
            counts[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++)
        {
            if(counts[i] > 0)
            {
                sb.append(String.format("%s:%s,", i, counts[i]));
            }
        }
        return sb.toString();
    }
}