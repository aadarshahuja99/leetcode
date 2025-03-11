class Solution {
    int[] ans;
    public int[] constructDistancedSequence(int n) {
        getAns(0, n, new int[2*n-1], new HashSet<>());
        return ans;
    }
    private boolean getAns(int currentIndex, int n, int[] arr, HashSet<Integer> used)
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
            if(getAns(currentIndex+1, n, arr, used))
            {
                return true;
            }
        }
        else
        {
            for(int i=n; i>=1; i--)
            {
                if(!used.contains(i) && ((currentIndex + (i) < 2*n-1 && arr[currentIndex + i] == 0) || (i == 1)))
                {
                    used.add(i);
                    arr[currentIndex] = i;
                    if(i != 1)
                    {
                        arr[currentIndex + i] = i;
                    }
                    if(getAns(currentIndex+1, n, arr, used))
                    {
                        return true;
                    }
                    used.remove(i);
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