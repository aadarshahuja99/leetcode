class Solution {
    public int longestSubstring(String s, int k) {
        HashSet<Character> uniqueCharacters = new HashSet<>();
        for(char c : s.toCharArray())
        {
            uniqueCharacters.add(c);
        }
        int uniqueCharacterCount = uniqueCharacters.size();
        int ans = 0;
        for(int i=1; i<= uniqueCharacterCount; i++)
        {
            ans = Math.max(ans, getAns(s, i, k));
        }
        return ans;
    }
    private int getAns(String s, int unique, int k)
    {
        HashMap<Character,Integer> hash = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int fulfilled = 0;
        int ans = 0;
        while(right < n)
        {
            if(hash.size() < unique)
            {
                hash.put(s.charAt(right), hash.getOrDefault(s.charAt(right), 0) + 1);
                if(hash.get(s.charAt(right)) == k)
                {
                    fulfilled++;
                }
                right++;
            }
            else if(hash.size() == unique)
            {
                while(right < n && hash.containsKey(s.charAt(right)))
                {
                    hash.put(s.charAt(right), hash.getOrDefault(s.charAt(right), 0) + 1);
                    right++;
                }
                boolean isValid = true;
                for(int val : hash.values())
                {
                    if(val < k)
                    {
                        isValid = false;
                        break;
                    }
                }
                if(isValid)
                {
                    ans = Math.max(ans, right - left);
                }
                while(unique == hash.size())
                {
                    hash.put(s.charAt(left), hash.get(s.charAt(left)) - 1);
                    if(hash.get(s.charAt(left)) == 0)
                    {
                        hash.remove(s.charAt(left));
                    }
                    left++;
                }
            }
        }
        if(unique == hash.size())
        {
            boolean isValid = true;
            for(int val : hash.values())
            {
                if(val < k)
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
            {
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
}