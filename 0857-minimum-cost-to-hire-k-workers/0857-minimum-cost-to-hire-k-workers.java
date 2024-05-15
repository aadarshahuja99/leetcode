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
        double ans = Double.MAX_VALUE;
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b) -> {
            return Double.compare(b[1],a[1]);
        });
        double qualitySum = 0;
        for(int i=k-1; i<n; i++)
        {
            double currentRatio = ratios[i][0];
            qualitySum += ratios[i][1];
            if(pq.size() == 0)
            {
                for(int j=0; j<k-1; j++)
                {
                    pq.add(ratios[j]);
                    qualitySum += ratios[j][1];
                }
            }
            ans = Math.min(ans, qualitySum*currentRatio);
            pq.add(ratios[i]);
            var top = pq.poll();
            qualitySum -= top[1];
        }
        return ans;
    }
}