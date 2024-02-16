import java.util.Map.Entry;
import java.util.SortedMap;
class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : word.toCharArray())
        {
            if(map.containsKey(c))
            {
                map.put(c,map.get(c) + 1);
            }
            else
            {
                map.put(c,1);
            }
        }
        if(map.size() == 1)
        {
            return true;
        }
        SortedMap<Integer,Integer> set = new TreeMap<Integer,Integer>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Entry kvp : map.entrySet())
        {
            if(set.containsKey(kvp.getValue()))
            {
                set.put((Integer)kvp.getValue(), set.get((Integer)kvp.getValue())+1);
            }
            else
            {
                set.put((Integer)kvp.getValue(), 1);
            }
            if(max < (Integer)kvp.getValue())
            {
                max = (Integer)kvp.getValue();
            }
            if(min > (Integer)kvp.getValue())
            {
                min = (Integer)kvp.getValue();
            }
            if(set.size() >= 3)
            {
                return false;
            }
        }
        if(set.size() == 1)
        {
            return max == 1;
        }
        if((min == 1 && (Integer)set.get(min) == 1))
        {
            return true;
        }
        //System.out.println((max-min)+" "+Math.abs(set.get(max)-set.get(min)));
        return max-min == 1 && ((Integer)set.get(max) == 1);
    }
}