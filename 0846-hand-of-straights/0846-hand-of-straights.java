class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int numCards = hand.length;
        if(numCards%groupSize != 0)
        {
            return false;
        }
        if(groupSize == 1)
        {
            return true;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int card : hand)
        {
            map.put(card, map.getOrDefault(card,0) + 1);
        }
        for(int key : map.keySet())
        {
            int currentCount = map.get(key);
            if(currentCount == 0)
            {
                continue;
            }
            for(int next = 1; next <= groupSize-1; next++)
            {
                if(!map.containsKey(key + next) || map.get(key + next) < map.get(key))
                {
                    return false;
                }
                map.put(key + next, map.get(key + next) - map.get(key));
            }
        }
        return true;
    }
}