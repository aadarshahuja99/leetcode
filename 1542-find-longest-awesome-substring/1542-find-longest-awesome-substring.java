class Solution {
    public int longestAwesome(String s) {
        // create bitmasks for substrings and hash them.
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        map.put(0,-1);
        int mask = 0;
        for(int i=0; i<n; i++)
        {
            int numIndex = s.charAt(i) - 48;
            // flip the bit for every occurrence, even occs: 0, odd occs: 1
            mask = mask^(1<<numIndex);
            // for all-even case
            if(map.containsKey(mask))
            {
                ans = Math.max(ans, i-map.get(mask));
            }
            for(int j=0; j<10; j++)
            {
                int newMask = mask^(1<<j);
                if(map.containsKey(newMask))
                {
                    ans = Math.max(ans, i-map.get(newMask));
                }
            }
            if(!map.containsKey(mask))
            {
                map.put(mask,i);
            }
        }
        return ans;
    }
}