class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> counts = new HashMap<>();
        int i=0;
        int j=0;
        int ans = 0;
        int n = s.length();
        while(j < n)
        {
            // consume the jth guy (expand the window)
            char cj = s.charAt(j);
            counts.put(cj, counts.getOrDefault(cj, 0) + 1);
            j++;
            // post consumption check if the window is invalid, if yes then shrink the window from the start to find the longest window that ends at the jth guy
            while(counts.get(cj) > 1)
            {
                char c = s.charAt(i);
                counts.put(c, counts.get(c) - 1);
                i++;
            }
            // compare the length of the longest window ending at the jth guy with the overall longest window
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}