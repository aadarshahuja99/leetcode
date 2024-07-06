class Solution {
    public int passThePillow(int n, int time) {
        int div = time/(n-1);
        int person = time%(n-1);
        if(div%2 == 0)
        {
            return person+1;
        }
        else
        {
            return n-person;
        }
    }
}