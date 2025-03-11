class Solution {
    int[] ans;
    public int[] constructDistancedSequence(int n) {
        getAns(0, n, new int[2*n-1], (int)Math.pow(2,n) - 1);
        return ans;
    }
    private boolean getAns(int currentIndex, int n, int[] arr, int state)
    {
        if(currentIndex == 2*n-1)
        {
            // System.out.println("found an ans");
            if(ans == null)
            {
                ans = arr.clone();
            }
            return true;
        }
        if(arr[currentIndex] != 0)
        {
            if(getAns(currentIndex+1, n, arr, state))
            {
                return true;
            }
        }
        else
        {
            for(int i=n; i>=1; i--)
            {
                if((state&(1<<(i-1))) > 0 && ((currentIndex + (i) < 2*n-1 && arr[currentIndex + i] == 0) || (i == 1)))
                {
                    state = (state^(1<<(i-1)));
                    arr[currentIndex] = i;
                    if(i != 1)
                    {
                        arr[currentIndex + i] = i;
                    }
                    if(getAns(currentIndex+1, n, arr, state))
                    {
                        return true;
                    }
                    state = (state^(1<<(i-1)));
                    arr[currentIndex] = 0;
                    if(i != 1)
                    {
                        arr[currentIndex + i] = 0;
                    }
                }
            }
        }
        return false;
    }
}