class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allCombinations = new ArrayList<String>();
        getParenthesis(0, 0, 0, new StringBuilder(), allCombinations, n);
        return allCombinations;
    }
    private void getParenthesis(int currentIndex, int opened, int closed, StringBuilder currentString, List<String> allCombinations, int n)
    {
        if(currentIndex == 2*n)
        {
            allCombinations.add(new String(currentString));
            return;
        }
        if(opened < n)
        {
            currentString.append("(");
            getParenthesis(currentIndex+1, opened+1, closed, currentString, allCombinations, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }
        if (opened > closed)
        {
            currentString.append(")");
            getParenthesis(currentIndex+1, opened, closed+1, currentString, allCombinations, n);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}