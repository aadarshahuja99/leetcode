class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        // same as remove k digits
        int n = nums.length;
        int toBeRemoved = n - k;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int num : nums)
        {
            while(!stack.isEmpty() && toBeRemoved > 0 && stack.getLast() > num)
            {
                stack.removeLast();
                toBeRemoved--;
            }
            stack.addLast(num);
        }
        while(toBeRemoved > 0)
        {
            stack.removeLast();
            toBeRemoved--;
        }
        int idx = 0;
        int[] ans = new int[k];
        while(!stack.isEmpty())
        {
            ans[idx] = stack.removeFirst();
            idx++;
        }
        return ans;
    }
}