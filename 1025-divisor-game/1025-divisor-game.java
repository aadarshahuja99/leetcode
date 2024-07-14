class Solution {
    public boolean divisorGame(int N) {
        if(N == 1){
            return false;
        }
        boolean[] res = new boolean[N + 1];
        res[1] = false;
        res[2] = true;
        for(int i = 3; i <= N; i++){
            res[i] = false;
            for(int j = 1; j < i; j++){
                if(i % j == 0 && !res[i - j]){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[N];
    }
}