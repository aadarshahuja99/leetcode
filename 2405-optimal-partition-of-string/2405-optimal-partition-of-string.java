class Solution {
    public int partitionString(String s) {
        int i=0;
        int n = s.length();
        int count = 0;
        while(i < n)
        {
            HashSet<Character> set = new HashSet<>();
            int j=i;
            while(j < n && !set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
            }
            count++;
            i=j;
        }
        return count;
    }
}