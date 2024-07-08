class Solution {
    public int numTeams(int[] rating) {
        // nlogn solution using BIT
        int n = rating.length;
        BIT bit = new BIT();
        int[] temp = new int[n];
        int[] temp2 = new int[n];
        for(int i=n-1; i>=0; i--)
        {
            int val = rating[i];
            int right = bit.get(100000) - bit.get(val);
            int smaller = bit.get(val-1);
            bit.set(val,1);
            temp[i] = right;
            temp2[i] = smaller;
            // System.out.println(val+" "+right);
        }
        BIT bit2 = new BIT();
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            int val = rating[i];
            int left = bit2.get(val-1);
            int larger = bit2.get(100000) - bit2.get(val);
            bit2.set(val,1);
            ans += temp[i]*left + temp2[i]*larger;
            // System.out.println(val+" "+left);
        }
        return ans;
    }
    class BIT
    {
        int[] tree;
        public BIT()
        {
            tree = new int[100001];
        }
        public int get(int index)
        {
            int sum = 0;
            while(index > 0)
            {
                sum += tree[index];
                index -= (index&(-index));
            }
            return sum;
        }
        public void set(int index, int val)
        {
            while(index < tree.length)
            {
                tree[index] += val;
                index += (index&(-index));
            }
        }
    }
}