class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> validNumbers = new ArrayList<>();
        getNumbers(0,0,k,n,0,validNumbers);
        int[] answer = new int[validNumbers.size()];
        int index = 0;
        for(int validNumber : validNumbers)
        {
            answer[index] = validNumber;
            index++;
        }
        return answer;
    }
    private void getNumbers(int currentIndex, int lastDigit, int k, int n, int currentNumber, ArrayList<Integer> answers)
    {
        if(currentIndex == n)
        {
            answers.add(currentNumber);
            return;
        }
        int ans = 0;
        if(currentIndex == 0)
        {
            for(int i=1; i<=9; i++)
            {
                getNumbers(currentIndex+1, i, k, n, currentNumber*10 + i, answers);
            }
        }
        else
        {
            int lesser = lastDigit - k;
            int greater = lastDigit + k;
            if(lesser >= 0 && lesser < 10)
            {
                getNumbers(currentIndex+1, lesser, k, n, currentNumber*10 + lesser, answers);
            }
            if(greater >= 0 && greater < 10 && greater != lesser)
            {
                getNumbers(currentIndex+1, greater, k, n, currentNumber*10 + greater, answers);
            }
        }
    }
}