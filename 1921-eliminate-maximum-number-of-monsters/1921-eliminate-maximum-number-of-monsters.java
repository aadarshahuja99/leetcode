class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] times = new double[n];
        for(int i=0; i<n; i++)
        {
            times[i] = 1.0*dist[i]/(1.0*speed[i]);
        }
        Arrays.sort(times);
        int currentTime = 0;
        int count = 0;
        for(int i=0; i<n; i++)
        {
            if(currentTime < times[i])
            {
                currentTime++;
                count++;
            }
            else
            {
                break;
            }
        }
        return count;
    }
}