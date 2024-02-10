class Solution {
    public boolean canReach(int[] arr, int start) {
        return getAns(start,arr,new int[arr.length]);
    }
    private boolean getAns(int current, int[] arr, int[] visited)
    {
        if(arr[current] == 0)
        {
            return true;
        }
        visited[current] = 1;
        boolean ans = false;
        if(current-arr[current] >= 0 && visited[current-arr[current]] == 0)
        {
            ans = ans || getAns(current-arr[current],arr,visited);
            if(ans)
            {
                return true;
            }
            visited[current-arr[current]] = 0;
        }
        if(current+arr[current] <= arr.length-1 && visited[current+arr[current]] == 0)
        {
            ans = ans || getAns(current+arr[current],arr,visited);
            if(ans)
            {
                return true;
            }
            visited[current+arr[current]] = 0;
        }
        return false;
    }
}