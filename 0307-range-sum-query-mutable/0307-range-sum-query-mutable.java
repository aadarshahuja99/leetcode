class NumArray {
    int[] fen;
    int n;
    int[] numbers;
    public NumArray(int[] nums) {
        fen = new int[nums.length+1];
        n = nums.length;
        numbers = new int[n];
        for(int i=0; i<nums.length; i++)
        {
            update(i, nums[i]);
            // System.out.println("fen value: " + fen[i+1]);
        }
    }
    
    public void update(int index, int val) {
        int indexInTree = index+1;
        while(indexInTree <= n)
        {
            fen[indexInTree] += val - numbers[index];
            // System.out.println(fen[indexInTree]+" "+indexInTree);
            indexInTree = indexInTree + (indexInTree&(-indexInTree));
        }
        numbers[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        int start = left;
        int end = right+1;
        return getSumTill(end) - getSumTill(start);
    }
    private int getSumTill(int index)
    {
        int sum = 0;
        while(index >= 1)
        {
            sum += fen[index];
            // System.out.println(index+" "+sum);
            index -= (index&(-index));
        }
        // System.out.println();
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */