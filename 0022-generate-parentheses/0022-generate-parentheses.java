class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allCombinations = new ArrayList<String>();
        getParenthesis(0, 0, "", allCombinations, n);
        return allCombinations;
    }
    private void getParenthesis(int currentIndex, int opened, String currentString, List<String> allCombinations, int n)
    {
        if(currentIndex == 2*n)
        {
            if(opened == 0)
            {
                allCombinations.add(currentString);
            }
            return;
        }
        if(opened > 0)
        {
            getParenthesis(currentIndex+1, opened+1, currentString+"(", allCombinations, n);
            getParenthesis(currentIndex+1, opened-1, currentString+")", allCombinations, n);
        }
        else
        {
            getParenthesis(currentIndex+1, opened+1, currentString+"(", allCombinations, n);
        }
    }
}