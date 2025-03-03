class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            return b[1] - a[1];
        });
        int[] last = {-1, -1};
        int[] counts = new int[26];
        for(char c : s.toCharArray())
        {
            counts[c-'a']++;
        }
        for(int i=0; i<26; i++)
        {
            if(counts[i] > 0)
            {
                maxHeap.add(new int[] { 'a'+i, counts[i] });
            }
        }
        while(maxHeap.size() > 0)
        {
            int[] top = maxHeap.poll();
            sb.append((char)top[0]);
            top[1]--;
            if(last[0] != -1 && last[1] > 0)
            {
                maxHeap.add(last);
            }
            last = top;
        }
        if(sb.length() < s.length())
        {
            return "";
        }
        return sb.toString();
    }
}