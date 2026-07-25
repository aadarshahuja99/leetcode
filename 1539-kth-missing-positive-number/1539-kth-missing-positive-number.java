class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) >= k) r = mid-1;  //missed more or equal than k numbers, left side;
            else l = mid + 1;   // missed less than k numbers, must be in the right side;
        }
        // answer will be from formula: arr[r] + (k - (arr[r] - (r+1))); the formula simplifies to r+1 + k
        return r+1+k;
    }
}