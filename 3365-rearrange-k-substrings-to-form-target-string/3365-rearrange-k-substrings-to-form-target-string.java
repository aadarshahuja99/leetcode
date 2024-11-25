class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if(k == s.length())
        {
            return true;
        }
        HashMap<String,Integer> sCount = new HashMap<>();
        HashMap<String,Integer> tCount = new HashMap<>();
        int size = s.length()/k;
        int n = s.length();
        for(int left = 0; left <= n-size; left += size)
        {
            String sub1 = s.substring(left, left+size);
            String sub2 = t.substring(left, left+size);
            sCount.put(sub1, sCount.getOrDefault(sub1, 0) + 1);
            tCount.put(sub2, tCount.getOrDefault(sub2, 0) + 1);
        }
        return sCount.equals(tCount);
    }
}