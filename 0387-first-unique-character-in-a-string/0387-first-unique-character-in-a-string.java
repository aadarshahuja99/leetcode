class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,ArrayList<Integer>> chars = new HashMap<>();
        int idx = 0;
        for(char c : s.toCharArray())
        {
            if(!chars.containsKey(c))
            {
                chars.put(c, new ArrayList<>());
            }
            chars.get(c).add(idx);
            idx++;
        }
        int n = s.length();
        int first = n+1;
        for(int i=0; i<26; i++)
        {
            char c = (char)('a' + i);
            if(chars.containsKey(c) && chars.get(c).size() == 1)
            {
                if(first > chars.get(c).get(0))
                {
                    first = chars.get(c).get(0);
                }
            }
        }
        return first == n+1 ? -1 : first;
    }
}