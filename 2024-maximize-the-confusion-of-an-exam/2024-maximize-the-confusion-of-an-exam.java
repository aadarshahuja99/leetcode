class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i=0;
        int j=0;
        int countT = 0;
        int countF = 0;
        int ans = 0;
        int n = answerKey.length();
        while(j < n)
        {
            if(answerKey.charAt(j) == 'T')
            {
                countT++;
            }
            else
            {
                countF++;
            }
            j++;
            while(countT > k && countF > k)
            {
                if(answerKey.charAt(i) == 'T')
                {
                    countT--;
                }
                else
                {
                    countF--;
                }
                i++;
            }
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}