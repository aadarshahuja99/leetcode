class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // fixed size sliding window solution
        HashMap<Character,Integer> target = new HashMap<>();
        for(char c : p.toCharArray())
        {
            target.put(c, target.getOrDefault(c,0) + 1);
        }
        int satisfied = 0;
        int j = 0;
        int i = 0;
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        while(j < n)
        {
            char cj = s.charAt(j);
            if(target.containsKey(cj))
            {
                target.put(cj, target.get(cj) - 1);
                if(target.get(cj) == 0)
                {
                    satisfied++;
                }
            }
            j++;
            if(j-i == p.length())
            {
                if(satisfied == target.size())
                {
                    ans.add(i);
                }
                // move i by 1
                char ci = s.charAt(i);
                if(target.containsKey(ci))
                {
                    target.put(ci, target.get(ci) + 1);
                    if(target.get(ci) == 1)
                    {
                        satisfied--;
                    }
                }
                i++;
            }
        }
        return ans;
    }
}