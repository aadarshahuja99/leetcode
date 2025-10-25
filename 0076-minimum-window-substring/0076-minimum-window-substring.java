class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> targets = new HashMap<>();
        for(char c : t.toCharArray())
        {
            targets.put(c, targets.getOrDefault(c,0) + 1);
        }

        int i = 0;
        int j = 0;
        int n = s.length();
        int fulfilled = 0;
        int ansStart = -1;
        int ansLength = n+1;

        while(j < n)
        {
            // consume j
            if(targets.containsKey(s.charAt(j)))
            {
                targets.put(s.charAt(j), targets.get(s.charAt(j)) - 1);
                if(targets.get(s.charAt(j)) == 0)
                {
                    fulfilled++;
                }
            }
            j++;
            // while the window is valid, keep updating the answer and shrink
            while(fulfilled == targets.size())
            {
                if(ansLength > (j - i))
                {
                    ansLength = j-i;
                    ansStart = i;
                }
                if(targets.containsKey(s.charAt(i)))
                {
                    targets.put(s.charAt(i), targets.get(s.charAt(i)) + 1);
                    if(targets.get(s.charAt(i)) == 1)
                    {
                        fulfilled--;
                    }
                }
                i++;
            }
        }
        if(ansStart == -1)
        {
            return "";
        }
        return s.substring(ansStart, ansStart + ansLength);
    }
}
