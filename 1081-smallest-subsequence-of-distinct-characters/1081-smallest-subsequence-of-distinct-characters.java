class Solution {
    public String smallestSubsequence(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int[] lasts = new int[26];
        int idx = 0;
        for(char c : s.toCharArray())
        {
            lasts[c-'a'] = idx;
            idx++;
        }
        boolean[] used = new boolean[26];
        idx = 0;
        for(char c : s.toCharArray())
        {
            if(used[c-97])
            {
                idx++;
                continue;
            }
            used[c-97] = true;
            while(!stack.isEmpty() && (lasts[stack.peekLast() - 97] > idx && stack.peekLast() - 97 > c - 97))
            {
                used[stack.peekLast() - 97] = false;
                stack.removeLast();
            }
            idx++;
            stack.addLast(c);
        }
        String ans = "";
        while(!stack.isEmpty())
        {
            ans += stack.removeFirst();
        }
        return ans;
    }
}