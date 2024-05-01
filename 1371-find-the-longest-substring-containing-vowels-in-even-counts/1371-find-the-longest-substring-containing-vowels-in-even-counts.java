class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Character,Integer> vowelIndexMap = new HashMap<>();
        vowelIndexMap.put('a',0);
        vowelIndexMap.put('e',1);
        vowelIndexMap.put('i',2);
        vowelIndexMap.put('o',3);
        vowelIndexMap.put('u',4);
        HashMap<Integer,Integer> stateMap = new HashMap<>();
        stateMap.put(0, -1);
        int currentState = 0;
        int ans = 0;
        int idx = 0;
        for(char c : s.toCharArray())
        {
            // flip the bit for the current vowel
            if(vowelIndexMap.get(c) != null)
            {
                int index = vowelIndexMap.get(c);
                currentState = (currentState^(1<<index));
            }
            if(stateMap.containsKey(currentState))
            {
                ans = Math.max(ans, idx - stateMap.get(currentState));
            }
            if(!stateMap.containsKey(currentState))
            {
                stateMap.put(currentState, idx);
            }
            idx++;
        }
        return ans;
    }
}