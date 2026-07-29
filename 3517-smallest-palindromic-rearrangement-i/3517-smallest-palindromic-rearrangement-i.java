class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length(); 
        int[] counts = new int[26];
        for(char c : s.toCharArray())
        {
            counts[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Deque<Character> deque = new ArrayDeque<>();
        for(int i=0; i<26; i++)
        {
            if(counts[i]%2 == 1)
            {
                deque.addLast((char)(i + 'a'));
                if(counts[i] > 1)
                {
                    pq.add(new int[] { i, counts[i]-1 });
                }
            }
            else if(counts[i] > 0)
            {
                pq.add(new int[] { i, counts[i] });
            }
        }
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            char c = (char)(top[0] + 'a');
            int count = top[1];
            deque.addFirst(c);
            deque.addLast(c);
            if(count > 2)
            {
                pq.add(new int[] { top[0], count-2 });
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : deque)
        {
            sb.append(c);
        }
        return sb.toString();
    }
}