class Solution {
    public int findRotateSteps(String ring, String key) {
        int ringLength = ring.length();
        HashMap<Character, ArrayList<Integer>> ringMap = new HashMap<>();
        int idx = 0;
        for(char c : ring.toCharArray())
        {
            if(!ringMap.containsKey(c))
            {
                ringMap.put(c, new ArrayList<>());
            }
            ringMap.get(c).add(idx);
            idx++;
        }
        int[][] cache = new int[ringLength][key.length()];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getMinSteps(0, 0, ringMap, key, ringLength, cache);
    }
    private int getMinSteps(int currentKeyIndex, int currentRingIndex, HashMap<Character, ArrayList<Integer>> ringMap, String key, int ringLength, int[][] cache)
    {
        if(currentKeyIndex == key.length())
        {
            return 0;
        }
        if(cache[currentRingIndex][currentKeyIndex] != -1)
        {
            return cache[currentRingIndex][currentKeyIndex];
        }
        char currentCharacter = key.charAt(currentKeyIndex);
        ArrayList<Integer> currentCharacterIndexes = ringMap.get(currentCharacter);
        int minDistance = 101*100;
        for(int index : currentCharacterIndexes)
        {
            int nextMoveDistance = Math.min(Math.abs(index - currentRingIndex),
            ringLength - Math.abs(index - currentRingIndex));
            minDistance = Math.min(minDistance, nextMoveDistance + 1 + getMinSteps(currentKeyIndex+1, index, ringMap, key, ringLength, cache));
        }
        return cache[currentRingIndex][currentKeyIndex] = minDistance;
    }
}