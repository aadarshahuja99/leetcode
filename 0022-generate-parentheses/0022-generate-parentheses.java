class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allCombinations = new ArrayList<String>();
        getParenthesis(0, 0, new StringBuilder(), allCombinations, n);
        return allCombinations;
    }
    private void getParenthesis(int currentIndex, int opened, StringBuilder currentString, List<String> allCombinations, int n)
    {
        if(currentIndex == 2*n)
        {
            if(opened == 0)
            {
                allCombinations.add(new String(currentString));
            }
            return;
        }
        if(opened > 0)
        {
            currentString.append("(");
            getParenthesis(currentIndex+1, opened+1, currentString, allCombinations, n);
            currentString.deleteCharAt(currentString.length() - 1);
            currentString.append(")");
            getParenthesis(currentIndex+1, opened-1, currentString, allCombinations, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }
        else
        {
            currentString.append("(");
            getParenthesis(currentIndex+1, opened+1, currentString, allCombinations, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}