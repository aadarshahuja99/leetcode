class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> map = new HashSet<>();
        for(int num : arr)
        {
            if(num%2 == 0)
            {
                if(map.contains(num/2) || map.contains(num*2))
                {
                    return true;
                }
            }
            else
            {
                if(map.contains(num*2))
                {
                    return true;
                }
            }
            map.add(num);
        }
        return false;
    }
}