class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        // bitmasking works here
        HashSet<Integer> set = new HashSet<>();
        for(String word : startWords)
        {
            int mask = 0;
            for(char c : word.toCharArray())
            {
                int idx = c - 97;
                mask = (mask|(1<<idx));
            }
            // System.out.println("st: "+word+" "+mask+" "+Integer.bitCount(mask));
            set.add(mask);
        }
        int ans = 0;
        for(String word : targetWords)
        {
            int mask = 0;
            for(char c : word.toCharArray())
            {
                int idx = c - 97;
                mask = (mask|(1<<idx));
            }
            // System.out.println("tr: "+word+" "+mask+" "+Integer.bitCount(mask));
            for(int i=0; i<26; i++)
            {
                if((mask&(1<<i)) > 0)
                {
                    int newMask = (mask^(1<<i));
                    if(set.contains(newMask))
                    {
                        // System.out.println(newMask+" "+mask);
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}