class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int floor = -1;
        int s = 0;
        int e = arr.length-1;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(arr[m] <= x)
            {
                floor = m;
                s = m+1;
            }
            else
            {
                e = m-1;
            }
        }
        int left = floor;
        int right = floor+1;
        LinkedList<Integer> list = new LinkedList<>();
        while(k > 0)
        {
            int leftDiff = Integer.MAX_VALUE;
            int rightDiff = Integer.MAX_VALUE;
            if(left >= 0)
            {
                leftDiff = x - arr[left];
            }
            if(right < arr.length)
            {
                rightDiff = arr[right] - x;
            }
            if(leftDiff <= rightDiff)
            {
                list.addFirst(arr[left]);
                left--;
            }
            else
            {
                list.addLast(arr[right]);
                right++;
            }
            k--;
        }
        return new ArrayList<>(list);
    }
}