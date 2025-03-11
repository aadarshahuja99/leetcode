class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> counts = new HashMap<>();
        int i=0;
        int j=0;
        int ans = 0;
        int n = s.length();
        while(j < n)
        {
            char cj = s.charAt(j);
            counts.put(cj, counts.getOrDefault(cj, 0) + 1);
            j++;
            while(counts.get(cj) > 1)
            {
                char c = s.charAt(i);
                counts.put(c, counts.get(c) - 1);
                if(counts.get(c) == 0)
                {
                    counts.remove(c);
                }
                i++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}