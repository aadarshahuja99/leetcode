class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int s = 0;
        int score = 0;
        int max = 0;
        int e = tokens.length-1;
        while(s <= e)
        {
            if(tokens[s] <= power)
            {
                score++;
                max = Math.max(score, max);
                power -= tokens[s];
                s++;
            }
            else if(score > 0)
            { 
                score--;
                power += tokens[e];
                e--;
            }
            else
            {
                return max;
            }
        }
        return max;
    }
}