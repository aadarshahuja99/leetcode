class Solution {
    public String addSpaces(String s, int[] spaces) {
        int ptr = 0;
        int n = s.length();
        int j=0;
        StringBuilder sb = new StringBuilder();
        while(ptr < n)
        {
            if(j < spaces.length && ptr == spaces[j])
            {
                sb.append(" ");
                j++;
            }
            else
            {
                sb.append(s.charAt(ptr));
                ptr++;
            }
        }
        return sb.toString();
    }
}