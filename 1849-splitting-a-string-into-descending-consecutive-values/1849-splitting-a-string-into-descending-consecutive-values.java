class Solution {
    public boolean splitString(String s) {
        return checkIfTheStringCanBeSplit(0,-1l,0,s);
    }
    private boolean checkIfTheStringCanBeSplit(int currentIndex, long lastValue, int numSplits, String s)
    {
        if(currentIndex == s.length() && numSplits > 0)
        {
            return true;
        }
        long currentValue = 0;
        boolean currentStatus = false;
        for(int i=currentIndex; i<s.length(); i++)
        {
            int iValue = s.charAt(i) - 48;
            currentValue = currentValue*10 + 1l*iValue;
            if(((lastValue == -1) || (currentValue == lastValue-1)))
            {
                currentStatus = currentStatus || checkIfTheStringCanBeSplit(i+1, currentValue, i == s.length()-1 ? numSplits : numSplits+1, s);
                if(currentStatus)
                {
                    // System.out.println("returning true for currentValue " + currentValue);
                    return true;
                }
            }
        }
        return currentStatus;
    }
}