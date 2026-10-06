class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        while(s <= e)
        {
            int m = s + (e-s)/2;
            if(m > 0 && m < arr.length-1 && arr[m] > arr[m-1] && arr[m] > arr[m+1])
            {
                return m;
            }
            else if((m > 0 && (arr[m] > arr[m-1])) || (m < arr.length-1 && arr[m] < arr[m+1]))
            {
                s = m+1;
            }
            else
            {
                e = m-1;
            }
            // System.out.println(s+ " " + e);
        }
        return -1;
    }
}