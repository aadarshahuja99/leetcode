class Solution {
    public int kBigIndices(int[] nums, int k) {
        int max = 0;
        for(int num : nums)
        {
            max = Math.max(max, num);
        }
        int n = nums.length;
        FenwickTree pre = new FenwickTree(max);
        int[] smaller = new int[n];
        for(int i=0; i<n; i++)
        {
            // System.out.println("calling smaller query for "+nums[i]);
            int count = pre.query(nums[i] - 1);
            smaller[i] = count;
            pre.update(nums[i]);
        }

        FenwickTree post = new FenwickTree(max);
        int[] greater = new int[n];
        int ans = 0;
        for(int i=n-1; i>=0; i--)
        {
            // System.out.println("calling post query for "+nums[i]);
            int count = post.query(nums[i] - 1);
            if(smaller[i] >= k && count >= k)
            {
                ans++;
            }
            post.update(nums[i]);
        }
        return ans;
    }
    class FenwickTree
    {
        int[] tree;
        int n;
        public FenwickTree(int size)
        {
            n = size;
            tree = new int[size+1];
        }
        public void update(int num)
        {
            num++;
            while(num <= n)
            {
                // System.out.println("updated "+num);
                tree[num] += 1;
                num += (num&(-num));
            }
        }
        public int query(int num)
        {
            num++;
            int sum = 0;
            while(num > 0)
            {
                sum += tree[num];
                // System.out.println("counted "+num);
                num -= (num&(-num));
            }
            // System.out.println("sum = "+sum);
            return sum;
        }
    }
}