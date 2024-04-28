class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] positions = new int[n];
        for(int i=0; i<n; i++)
        {
            positions[nums2[i]] = i;
        }
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        FenwickTree pre = new FenwickTree(n);
        for(int i=0; i<n; i++)
        {
            int index_in_nums2 = positions[nums1[i]];
            prefix[i] = pre.getCount(index_in_nums2);
            pre.update(index_in_nums2);
        }
        FenwickTree post = new FenwickTree(n);
        for(int i=n-1; i>=0; i--)
        {
            int index_in_nums2 = positions[nums1[i]];
            suffix[i] = post.getSuffixCount(index_in_nums2);
            post.update(index_in_nums2);
        }
        long ans = 0;
        for(int i=1; i<n-1; i++)
        {
            ans += 1L*prefix[i]*suffix[i];
        }
        return ans;
    }

    class FenwickTree
    {
        int size;
        int[] tree;
        public FenwickTree(int n)
        {
            size = n;
            tree = new int[n+1];
        }

        private void update(int index)
        {
            index++;
            while(index <= size)
            {
                tree[index] += 1;
                index += (index&(-index));
            }
        }

        private int getCount(int index)
        {
            int count = 0;
            while(index >= 1)
            {
                count += tree[index];
                index -= (index&(-index));
            }
            return count;
        }

        private int getSuffixCount(int index)
        {
            return getCount(size) - getCount(index+1);
        }
    }
}