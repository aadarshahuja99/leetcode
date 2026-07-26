class Solution {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        if(s.length() > 12)
        {
            return ans;
        }
        backtrack(0, 3, s, new StringBuilder());
        return ans;
    }
    private void backtrack(int idx, int dots, String s, StringBuilder sb)
    {
        if(idx == s.length())
        {
            return;
        }
        if(dots == 0)
        {
            if(idx == s.length() || s.length() - idx > 3 || (s.length() - idx > 1 && s.charAt(idx) == '0'))
            {
                return;
            }
            int num = 0;
            for(int i=idx; i<s.length(); i++)
            {
                num = num*10 + (s.charAt(i) - '0');
                if(num > 255)
                {
                    return;
                }
            }
            sb.append(num);
            ans.add(sb.toString());
            sb.delete(idx + 3, sb.length());
            return;
        }
        int number = 0;
        for(int i=idx; i<Math.min(s.length(),idx+3); i++)
        {
            number = number*10 + (s.charAt(i) - '0');
            if((number > 0 && number <= 255 && s.charAt(idx) != '0') || (number == 0 && i == idx) && dots > 0)
            {
                sb.append(number);
                sb.append('.');
                // System.out.println(sb.toString()+" after adding number "+number+" dots in function call = "+dots+" calling next with the index "+(i+1)+" dots = "+(dots-1));
                backtrack(i+1, dots-1, s, sb);
                sb.delete(sb.length() - (1 + i - idx + 1), sb.length());
            }
        }
    }
}