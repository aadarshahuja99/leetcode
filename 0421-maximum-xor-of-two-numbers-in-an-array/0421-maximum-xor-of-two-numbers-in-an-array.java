class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int[][] bitMap = new int[n][32];
        int idx = 0;
        Trie root = new Trie();
        for(int num : nums)
        {
            bitMap[idx] = getBits(num);
            root.insert(bitMap[idx]);
            idx++;
        }
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            // System.out.println("Computing for " + nums[i]);
            ans = Math.max(ans, root.getAns(bitMap[i]));
        }
        return ans;
    }
    private int[] getBits(int num)
    {
        int[] ans = new int[32];
        int idx = 31;
        while(idx >= 0)
        {
            // keeping the most significant bit first and so on
            ans[31-idx] = (num&(1<<idx)) > 0 ? 1 : 0;
            idx--;
        }
        return ans;
    }
    class Trie
    {
        Trie[] refs;
        public Trie()
        {
            refs = new Trie[2];
        }
        public void insert(int[] bits)
        {
            Trie current = this;
            for(int num : bits)
            {
                if(current.refs[num] == null)
                {
                    current.refs[num] = new Trie();
                }
                current = current.refs[num];
            }
        }
        public int getAns(int[] bits)
        {
            Trie current = this;
            int ans = 0;
            for(int idx = 0; idx<=31; idx++)
            {
                int complement = bits[idx] == 0 ? 1 : 0;
                if(current.refs[complement] == null)
                {
                    ans = ans|(0<<(31-idx));
                    current = current.refs[bits[idx]];
                }
                else
                {
                    ans = ans|(1<<(31-idx));
                    current = current.refs[complement];
                }
            }
            return ans;
        }
    }
}