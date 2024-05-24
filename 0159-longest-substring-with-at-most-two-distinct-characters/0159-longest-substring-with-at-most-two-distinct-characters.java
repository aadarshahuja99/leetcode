class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> occurrences = new HashMap<>();
        int ans = 0;
        while(end < n)
        {
            occurrences.put(s.charAt(end), occurrences.getOrDefault(s.charAt(end), 0) + 1);
            end++;
            if(occurrences.size() > 2)
            {
                ans = Math.max(ans, end - start - 1);
                while(occurrences.size() > 2)
                {
                    occurrences.put(s.charAt(start), occurrences.get(s.charAt(start)) - 1);
                    if(occurrences.get(s.charAt(start)) == 0)
                    {
                        occurrences.remove(s.charAt(start));
                    }
                    start++;
                }
            }
        }
        if(occurrences.size() > 2)
        {
            ans = Math.max(ans, end - start - 1);
            while(occurrences.size() > 2)
            {
                occurrences.put(s.charAt(start), occurrences.get(s.charAt(start)) - 1);
                if(occurrences.get(s.charAt(start)) == 0)
                {
                    occurrences.remove(s.charAt(start));
                }
                start++;
            }
        }
        else
        {
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}