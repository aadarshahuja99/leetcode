class NumMatrix {
    SegmentTree[] rowTrees;
    int cols;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        cols = n;
        rowTrees = new SegmentTree[m];
        for(int i=0; i<m; i++)
        {
            rowTrees[i] = new SegmentTree(n, matrix[i]);
        }
    }
    
    public void update(int row, int col, int val) {
        var tree = rowTrees[row];
        tree.update(val, col);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i=row1; i<=row2; i++)
        {
            ans += rowTrees[i].getSum(col1, col2, 0, cols - 1, 0);
            // System.out.println("ans after "+i+" rowTree call = "+ans);
        }
        return ans;
    }

    class SegmentTree
    {
        int size;
        int[] tree;
        public SegmentTree(int n, int[] nums)
        {
            size = 4*n;
            tree = new int[size];
            initialize(nums, 0, 0, n - 1);
        }

        public void update(int val, int idx)
        {
            updateHelper(val, idx, 0, (size/4) - 1, 0);
        }

        private void updateHelper(int val, int idx, int ss, int se, int treeIndex)
        {
            if(ss == se)
            {
                tree[treeIndex] = val;
                return;
            }
            int mid = ss + (se - ss)/2;
            if(idx <= mid)
            {
                updateHelper(val, idx, ss, mid, 2*treeIndex + 1);
            }
            else
            {
                updateHelper(val, idx, mid + 1, se, 2*treeIndex + 2);
            }
            tree[treeIndex] = tree[2*treeIndex + 1] + tree[2*treeIndex + 2];
        }

        private void initialize(int[] arr, int treeIndex, int ss, int se)
        {
            if(ss == se)
            {
                tree[treeIndex] = arr[ss];
                return;
            }
            int mid = ss + (se - ss)/2;
            initialize(arr, 2*treeIndex+1, ss, mid);
            initialize(arr, 2*treeIndex+2, mid+1, se);
            tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];
        }

        public int getSum(int l, int r, int ss, int se, int treeIndex)
        {
            if(r < ss || l > se)
            {
                return 0;
            }
            if(ss >= l && se <= r)
            {
                // System.out.println("returning "+tree[treeIndex]+" for "+l+" "+r+" "+ss+" "+se+" "+treeIndex);
                return tree[treeIndex];
            }
            int mid = ss + (se - ss)/2;
            int left = getSum(l, r, ss, mid, 2*treeIndex+1);
            int right = getSum(l, r, mid+1, se, 2*treeIndex+2);
            // System.out.println("returning "+(left)+" + "+right+" for "+l+" "+r+" "+ss+" "+se+" "+treeIndex);
            return left + right;
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */