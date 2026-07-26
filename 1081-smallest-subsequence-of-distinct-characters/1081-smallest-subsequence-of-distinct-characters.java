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
            if(used[c-'a'])
            {
                idx++;
                continue;
            }
            used[c-'a'] = true;
            // if there is a character before me that is greater than me and also appears after me in the string, then remove that character from the string
            while(!stack.isEmpty() && (lasts[stack.peekLast() - 'a'] > idx && stack.peekLast() - 'a' > c - 'a'))
            {
                used[stack.peekLast() - 'a'] = false;
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