class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int numTwos = 0;
        int numThrees = 0;
        for(var kvp : map.entrySet())
        {
            // System.out.println(numTwos+" "+numThrees+" "+kvp.getValue()+" "+kvp.getKey());
            if(kvp.getValue() == 1)
            {
                return -1;
            }
            if(kvp.getValue()%3 == 1)
            {
                numTwos += 2;
                numThrees += (kvp.getValue()/3) - 1;
            }
            else if(kvp.getValue()%3 == 2)
            {
                numTwos += 1;
                numThrees += kvp.getValue()/3;
            }
            else
            {
                numThrees += kvp.getValue()/3;
            }
        })
        return numTwos + numThrees;
    }
}