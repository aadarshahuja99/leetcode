class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[] pointers = new int[nums1.length + nums2.length];
        ArrayList<List<Integer>> answers = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] combination1, int[] combination2)
            {
                return (nums1[combination1[0]] + nums2[combination1[1]]) - (nums1[combination2[0]] + nums2[combination2[1]]);
            }
        });
        for(int i=0; i<nums1.length; i++)
        {
            pq.add(new int[] { i,0 });
        }
        while(k-- > 0)
        {
            int[] top = pq.poll();
            int ptr1 = top[0];
            int ptr2 = top[1];
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(nums1[ptr1]);
            pair.add(nums2[ptr2]);
            answers.add(pair);
            if(ptr2+1 < nums2.length)
            {
                pq.add(new int[] { ptr1, ptr2+1 });
            }
        }
        return answers;
    }
}