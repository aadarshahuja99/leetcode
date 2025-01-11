class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
        {
            return false;
        }
        if(s.length() == k)
        {
            return true;
        }
        int[] map = new int[26];
        int uniqueChars = 0;
        for(char ch : s.toCharArray())
        {
            map[ch-'a']++;
            if(map[ch-'a'] == 1)
            {
                uniqueChars++;
            }
        }
        int odds = 0;
        for(int i=0; i<26; i++)
        {
            if(map[i]%2 == 1)
            {
                odds++;
            }
        }
        return odds <= k;
    }
}