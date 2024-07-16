class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // math based problem
        // sort the ratios first to choose the manager. Because: for a worker to be selected, wage = quality_w*ratio_m
        // wage >= min_wage_w
        // quality_w*ratio_m >= min_wage_w
        // ratio_m >= min_wage_w/quality_w
        // ratio_m >= ratio_w
        int n = wage.length;
        double[][] ratios = new double[n][2];
        for(int i=0; i<n; i++)
        {
            ratios[i][0] = (double)wage[i]/(double)quality[i];
            ratios[i][1] = (double)quality[i];
        }
        Arrays.sort(ratios, (a,b) -> {
            return Double.compare(a[0], b[0]);
        });
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b) -> {
            return Double.compare(b[1],a[1]);
        });
        double qualitySum = 0;
        for(int j=0; j<k; j++)
        {
            pq.add(ratios[j]);
            qualitySum += ratios[j][1];
        }
        double ans = qualitySum*ratios[k-1][0];
        for(int i=k; i<n; i++)
        {
            var top = pq.poll();
            qualitySum += ratios[i][1] - top[1];
            pq.add(ratios[i]);
            ans = Math.min(ans, qualitySum*ratios[i][0]);
        }
        return ans;
    }
}