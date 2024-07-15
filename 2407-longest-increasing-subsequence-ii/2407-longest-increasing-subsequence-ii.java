class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int max = 0;
        for(int num : nums)
        {
            max = Math.max(max, num);
        }
        int ans = 0;
        SegmentTree tree = new SegmentTree(max+1);
        for(int num : nums)
        {
            int length = tree.query(Math.max(0, num-k), num - 1);
            tree.update(length+1, num);
            ans = Math.max(length+1, ans);
        }
        return ans;
    }
    class SegmentTree
    {
        int[] tree;
        int size;
        public SegmentTree(int n)
        {
            size = n;
            tree = new int[4*n];
        }
        public void update(int val, int idx)
        {
            updateHelper(val, idx, 0, 0, size);
        }
        private void updateHelper(int val, int idx, int treeIndex, int ss, int se)
        {
            if(ss == se)
            {
                tree[treeIndex] = val;
                return;
            }
            int mid = ss + (se - ss)/2; // used to binary search the segment tree array in update
            if(mid >= idx)
            {
                updateHelper(val, idx, 2*treeIndex+1, ss, mid); // treeIndex is the index in the array
            }
            else
            {
                updateHelper(val, idx, 2*treeIndex+2, mid+1, se);
            }
            tree[treeIndex] = Math.max(tree[2*treeIndex+1], tree[2*treeIndex+2]);
        }
        public int query(int l, int r)
        {
            return queryHelper(0, size, l, r, 0);
        }
        public int queryHelper(int ss, int se, int l, int r, int treeIndex)
        {
            if(ss > r || se < l)
            {
                return Integer.MIN_VALUE;
            }
            if(ss >= l && se <= r)
            {
                return tree[treeIndex];
            }
            int mid = ss + (se - ss)/2; // used to find the ranges in query
            int left = queryHelper(ss, mid, l, r, 2*treeIndex+1);
            int right = queryHelper(mid+1, se, l, r, 2*treeIndex+2);
            return Math.max(left, right);
        }
    }
}