class Solution {
    public long wonderfulSubstrings(String word) {
        HashMap<Integer,Long> stateMap = new HashMap<>();
        int currentState = 0;
        stateMap.put(0, 1L);
        long ans = 0;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            int alphabetIndex = c - 97;
            currentState = (currentState^(1<<alphabetIndex));
            if(stateMap.containsKey(currentState))
            {
                ans += stateMap.get(currentState);
                // System.out.println(currentState+" "+ans+" "+c+" "+i);
            }
            stateMap.put(currentState, stateMap.getOrDefault(currentState,0L) + 1L);
            for(int j=0; j<10; j++)
            {
                ans += stateMap.getOrDefault(currentState^(1<<j), 0L);
            }
        }
        return ans;
    }
}