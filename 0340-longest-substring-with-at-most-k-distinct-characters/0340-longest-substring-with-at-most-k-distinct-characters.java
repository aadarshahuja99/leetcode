class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0)
        {
            return 0;
        }
        HashMap<Character,Integer> windowMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int ans = 0;
        while(right < n)
        {
            if(windowMap.size() <= k)
            {
                ans = Math.max(ans, right-left);
                windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            else
            {
                while(windowMap.size() > k)
                {
                    windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                    if(windowMap.get(s.charAt(left)) == 0)
                    {
                        windowMap.remove(s.charAt(left));
                    }
                    left++;
                }
            }
        }
        if(windowMap.size() <= k)
        {
            ans = Math.max(ans, right-left);
        }
        else
        {
            while(windowMap.size() > k)
            {
                windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                if(windowMap.get(s.charAt(left)) == 0)
                {
                    windowMap.remove(s.charAt(left));
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}