class Solution {
    public int equalCountSubstrings(String s, int count) {
        // similar approach to longest palindromic substring
        // for each possible substring length (count of unique characters in this case,
        // check if a valid sliding window (fixed size) exists)
        // Binary search can also be applied to further optimize

        int uniqueCount = 0;
        HashSet<Character> uniqueCharacters = new HashSet<>();
        for(char c : s.toCharArray())
        {
            uniqueCharacters.add(c);
        }
        uniqueCount = uniqueCharacters.size();
        int n = s.length();
        int ans = 0;
        for(int i=1; i<=uniqueCount; i++)
        {
            ans += checkIfAValidWindowExists(i, s, count);
        }
        return ans;
    }

    private int checkIfAValidWindowExists(int unique, String s, int count)
    {
        int left = 0;
        int right = 0;
        int n = s.length();
        int current = 0;
        int windowSize = unique*count;
        HashMap<Character,Integer> countMap = new HashMap<>();
        int ans = 0;
        while(right < n)
        {
            if(right - left < windowSize)
            {
                countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            else if(right - left == windowSize)
            {
                if(countMap.size() == unique)
                {
                    boolean isValid = true;
                    for(int value : countMap.values())
                    {
                        if(value != count)
                        {
                            isValid = false;
                            break;
                        }
                    }
                    if(isValid)
                    {
                        ans++;
                    }
                }
                // move the left pointer
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                if(countMap.get(s.charAt(left)) == 0)
                {
                    countMap.remove(s.charAt(left));
                }
                left++;
            }
        }
        if(countMap.size() == unique)
        {
            boolean isValid = true;
            for(int value : countMap.values())
            {
                if(value != count)
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
            {
                ans++;
            }
        }
        // System.out.println(ans+" for "+unique+", "+count);
        return ans;
    }
}