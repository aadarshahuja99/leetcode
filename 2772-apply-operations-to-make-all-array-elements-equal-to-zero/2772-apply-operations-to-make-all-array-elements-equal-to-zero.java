class Solution {
    public boolean checkArray(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int n = nums.length;
        int operationsInCurrentWindow = 0;
        for(int i=0; i<n; i++)
        {
            if(i >= k)
            {
                operationsInCurrentWindow -= q.poll();
            }
            nums[i] -= operationsInCurrentWindow;
            if(nums[i] < 0)
            {
                return false;
            }
            if(i > nums.length - k && nums[i] != 0)
            {
                return false;
            }
            operationsInCurrentWindow += nums[i];
            q.add(nums[i]);
            nums[i] = 0;
        }
        return true;
    }
}