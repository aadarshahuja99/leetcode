class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        getCombinations(1, k, n, new LinkedList<>(), ans);
        return ans;
    }
    private void getCombinations(int number, int k, int n, LinkedList<Integer> current, List<List<Integer>> ans)
    {
        if(k == 0)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        if(number > n)
        {
            return;
        }
        // add number to the curent combination
        current.addLast(number);
        getCombinations(number+1, k-1, n, current, ans);
        current.removeLast();
        // do not add number to the current combination
        getCombinations(number+1, k, n, current, ans);
    }
}