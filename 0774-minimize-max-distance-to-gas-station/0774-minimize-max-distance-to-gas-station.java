class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        // brute-force idea: keep choosing the largest distance between 2 stations, and insert a station between them
        // brute force code:
        // double ans = 100000000;
        // int n = stations.length;
        // int[] differences = new int[n-1];
        // int[] count = new int[n-1];
        // Arrays.fill(count,1);
        // for(int i=0; i<n-1; i++)
        // {
        //     differences[i] = stations[i+1] - stations[i];
        // }
        // for(int i=0; i<k; i++)
        // {
        //     double currentMax = 0;
        //     int maxIndex = 0;
        //     double secondMax = 0;
        //     for(int j=0; j<n-1; j++)
        //     {
        //         double current = (double)differences[j]/count[j];
        //         if(currentMax < current)
        //         {
        //             maxIndex = j;
        //             secondMax = currentMax;
        //             currentMax = current;
        //         }
        //         else if(current >= secondMax)
        //         {
        //             secondMax = current;
        //         }
        //     }
        //     count[maxIndex] += 1;
        //     ans = secondMax;
        // }
        // return ans;

        // optimal solution can be found using binary search

        int n = stations.length;
        int[] distances = new int[n-1];
        for(int i=0; i<n-1; i++)
        {
            distances[i] = stations[i+1] - stations[i];
        }

        double start = 0.000001;
        double end = 100000000;
        double ans = 0;
        double factor = 0.000001;
        while(start <= end)
        {
            double mid = start + (end - start)/2.0;
            if(check(mid, k, distances))
            {
                ans = mid;
                end = mid - factor;
            }
            else
            {
                start = mid + factor;
            }
        }
        return ans;
    }

    private boolean check(double maxDistance, int k, int[] distances)
    {
        int count = 0;
        for(int distance : distances)
        {
            if(distance <= maxDistance)
            {
                continue;
            }
            count += Math.ceil((double)distance/maxDistance) - 1;
        }
        return count <= k;
    }
}