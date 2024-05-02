class Solution {
    public int balancedString(String s) {
        HashMap<Character,Integer> countMap = new HashMap<>();
        HashMap<Character,Integer> targets = new HashMap<>();
        int n = s.length();
        for(char c : s.toCharArray())
        {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        updateTargets('Q', targets, countMap, n);
        updateTargets('W', targets, countMap, n);
        updateTargets('E', targets, countMap, n);
        updateTargets('R', targets, countMap, n);

        if(targets.size() == 0)
        {
            return 0;
        }

        int i=0;
        int j=0;
        int ans = n;
        int fulfilled = 0;
        while(j < n)
        {
            if(fulfilled < targets.size())
            {
                if(targets.containsKey(s.charAt(j)))
                {
                    targets.put(s.charAt(j), targets.get(s.charAt(j)) - 1);
                    if(targets.get(s.charAt(j)) == 0)
                    {
                        fulfilled++;
                    }
                }
                j++;
            }
            else
            {
                int last = i;
                while(fulfilled == targets.size())
                {
                    if(targets.containsKey(s.charAt(i)))
                    {
                        targets.put(s.charAt(i), targets.get(s.charAt(i)) + 1);
                        if(targets.get(s.charAt(i)) == 1)
                        {
                            fulfilled--;
                        }
                    }
                    last = i;
                    i++;
                }
                ans = Math.min(ans, j-last);
                // System.out.println("1: setting ans to: "+ans);
            }
        }
        if(fulfilled == targets.size())
        {
            int last = i;
            while(fulfilled == targets.size())
            {
                if(targets.containsKey(s.charAt(i)))
                {
                    targets.put(s.charAt(i), targets.get(s.charAt(i)) + 1);
                    if(targets.get(s.charAt(i)) == 1)
                    {
                        fulfilled--;
                    }
                }
                last = i;
                i++;
            }
            ans = Math.min(ans, j-last);
            // System.out.println("setting ans to: "+ans);
        }
        return ans;
    }

    private void updateTargets(char character, HashMap<Character,Integer> targets, HashMap<Character,Integer> countMap, int n)
    {
        if(countMap.containsKey(character) && countMap.get(character) > n/4)
        {
            targets.put(character, countMap.get(character) - n/4);
        }
    }
}