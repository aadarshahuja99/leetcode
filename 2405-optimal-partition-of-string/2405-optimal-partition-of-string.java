class Solution {
    public int partitionString(String s) {
        int i=0;
        int n = s.length();
        int count = 0;
        while(i < n)
        {
            int mask = 0;
            HashSet<Character> set = new HashSet<>();
            int j=i;
            while(j < n && (mask&(1<<(s.charAt(j) - 'a'))) == 0)
            {
                mask = (mask|(1<<(s.charAt(j) - 'a')));
                j++;
            }
            count++;
            i=j;
        }
        return count;
    }
}