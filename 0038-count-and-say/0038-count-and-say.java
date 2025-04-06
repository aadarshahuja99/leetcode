class Solution {
    public String countAndSay(int n) {
        String current = "1";
        for(int i=0; i<n-1; i++)
        {
            var encoded = getRLE(current);
            current = encoded;
        }
        return current;
    }
    private String getRLE(String s)
    {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n;)
        {
            int j=i;
            char element = s.charAt(j);
            int count = 0;
            while(j < n && s.charAt(j) == element)
            {
                j++;
                count++;
            }
            sb.append(count);
            sb.append(element);
            i=j;
        }
        return sb.toString();
    }
}