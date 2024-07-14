class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int minLimit = Integer.MIN_VALUE;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num: preorder) {
            while (stack.size() > 0 && stack.peek() < num) {
                minLimit = stack.pop();
            }
            
            if (num < minLimit) {
                return false;
            }
            
            stack.push(num);
        }
        
        return true;
    }
}