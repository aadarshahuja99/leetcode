class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int end = n-1;
        int start = 0;
        int total = power;
        int score = 0;
        int max = 0;
        while(start <= end)
        {
            if(total >= tokens[start])
            {
                total -= tokens[start];
                score++;
                start++;
                max = Math.max(max, score);
            }
            else if(score > 0)
            {
                total += tokens[end];
                score--;
                end--;
            }
            else
            {
                return max;
            }
        }
        return max;
    }
}