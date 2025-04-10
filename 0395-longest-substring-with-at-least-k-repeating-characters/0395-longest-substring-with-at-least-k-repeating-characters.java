class Solution {
    public int longestSubstring(String s, int k) {
        HashSet<Character> uniqueCharacters = new HashSet<>();
        for(char c : s.toCharArray())
        {
            uniqueCharacters.add(c);
        }
        int uniqueCharacterCount = uniqueCharacters.size();
        int ans = 0;
        for(int i=1; i<=uniqueCharacterCount; i++)
        {
            ans = Math.max(ans, getAns(s, i, k));
        }
        return ans;
    }
    private int getAns(String s, int unique, int k)
    {
        int[] hash = new int[26];
        int left = 0;
        int right = 0;
        int n = s.length();
        int ans = 0;
        int count = 0;
        int valid = 0;
        while(right < n)
        {
            hash[s.charAt(right) - 'a']++;
            if(hash[s.charAt(right) - 'a'] == 1)
            {
                count++;
            }
            if(hash[s.charAt(right) - 'a'] == k)
            {
                valid++;
            }
            right++;
            while(count > unique)
            {
                hash[s.charAt(left) - 'a']--;
                if(hash[s.charAt(left) - 'a'] == 0)
                {
                    count--;
                }
                if(hash[s.charAt(left) - 'a'] == k-1)
                {
                    valid--;
                }
                left++;
            }
            if(count == unique && valid == unique)
            {
                // System.out.println("count = "+count+" for "+left+","+(right-1));
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
}