class Solution {
    public int minFlipsMonoIncr(String S) {
        int zeroOnRight = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0'){
                zeroOnRight++;
            }
        }
        // partition at beginning
        int ans = zeroOnRight;
        int oneOnLeft = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0'){
                zeroOnRight--;
            }
            else{
                oneOnLeft++;
            }
            ans = Math.min(ans, oneOnLeft + zeroOnRight);
        }
        // partition at ending
        ans = Math.min(ans, oneOnLeft);
        return ans;
    }
}