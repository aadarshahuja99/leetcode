class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 >= n1)
        {
            return findMedian(nums1, nums2);
        }
        return findMedian(nums2, nums1);
    }
    private double findMedian(int[] smaller, int[] larger)
    {
        int n1 = smaller.length;
        int n2 = larger.length;
        if(n1 == 0 && n2 == 0)
        {
            return 0;
        }
        int left = (n1 + n2 + 1)/2;
        int start = 0;
        int end = n1-1;
        boolean isOddLength = (n1+n2)%2 == 1;
        if(n1 == 0)
        {
            return isOddLength ? larger[n2/2] : ((double)larger[n2/2-1] + (double)larger[n2/2])/2.0;
        }
        while(start <= end)
        {
            int mid1 = start + (end - start)/2;
            int mid2 = left - mid1 - 2;

            int l1 = smaller[mid1];
            int l2 = mid2 < 0 ? Integer.MIN_VALUE : larger[mid2];
            int r1 = mid1+1 == n1 ? Integer.MAX_VALUE : smaller[mid1+1];
            int r2 = mid2+1 == n2 ? Integer.MAX_VALUE : larger[mid2+1];

            // System.out.println(l1+" "+l2+" "+r1+" "+r2+ " " +start+" "+end);

            if(l1 <= r2 && l2 <= r1)
            {
                if(isOddLength)
                {
                    return (double)Math.max(l1, l2);
                }
                else
                {
                    return ((double)Math.max(l1, l2) + (double)Math.min(r1, r2))/2.0;
                }
            }
            else if(l1 > r2)
            {
                end = mid1 - 1;
            }
            else
            {
                start = mid1 + 1;
            }
        }
        return isOddLength ? larger[left-1] : ((double)larger[left-1] + (left == n2 ? (double)smaller[0] : Math.min((double)larger[left], (double)smaller[0])))/2.0;
    }
}