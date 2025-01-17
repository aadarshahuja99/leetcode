class Solution {
    public int maximumSwap(int num) {
        List<Integer> digits = new ArrayList<>();
        while(num > 0)
        {
            digits.add(num%10);
            num = num/10;
        }
        Collections.reverse(digits);
        int[] maxIndex = new int[digits.size()];
        maxIndex[digits.size()-1] = -1;
        for(int i=digits.size()-2; i>=0; i--)
        {
            int maxIndexSoFar = maxIndex[i+1];
            if(maxIndexSoFar == -1 || digits.get(i+1) > digits.get(maxIndexSoFar))
            {
                maxIndexSoFar = i+1;
            }
            maxIndex[i] = maxIndexSoFar;
        }
        for(int i=0; i<digits.size()-1; i++)
        {
            if(digits.get(i) < digits.get(maxIndex[i]))
            {
                int temp = digits.get(i);
                digits.set(i, digits.get(maxIndex[i]));
                digits.set(maxIndex[i], temp);
                break;
            }
        }
        int ans = 0;
        for(int i=0; i<digits.size(); i++)
        {
            ans = ans*10 + digits.get(i);
        }
        return ans;
    }
}