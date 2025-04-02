class Solution {
    public int minMovesToMakePalindrome(String s) {
        // greedy and 2 pointers, if l and r do not match, move r until l is reached, if a matching char is found before reaching lth index, swap the matching char index and rth guy. add (r - k) to cost (number of swaps). If no matching char is found till the lth index, then simply swap lth guy with l+1th index and add 1 to cost
        int l = 0;
        int n = s.length();
        int r = n-1;
        int steps = 0;
        char[] arr = s.toCharArray();
        while(l < r)
        {
            if(arr[l] == arr[r])
            {
                l++;
                r--;
            }
            else
            {
                int k = r;
                while(k > l)
                {
                    if(arr[l] == arr[k])
                    {
                        break;
                    }
                    k--;
                }
                if(k == l)
                {
                    swap(arr, l, l+1);
                    steps++;
                }
                else
                {
                    while(k < r)
                    {
                        swap(arr, k, k+1);
                        k++;
                        steps++;
                    }
                    l++;
                    r--;
                }
            }
        }
        return steps;
    }
    private void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}