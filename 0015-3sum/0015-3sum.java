class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n = nums.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n;)
        {
            int j=i+1;
            int k=n-1;
            int target = clone[i];
            while(j < k)
            {
                if(clone[j] + clone[k] + target == 0)
                {
                    var list = new ArrayList<Integer>();
                    list.add(clone[i]);
                    list.add(clone[j]);
                    list.add(clone[k]);
                    ans.add(list);
                    int temp = k-1;
                    while(temp >= 0 && clone[temp] == clone[k])
                    {
                        temp--;
                    }
                    k = temp;
                    temp = j+1;
                    while(temp < n && clone[temp] == clone[j])
                    {
                        temp++;
                    }
                    j = temp;
                }
                else if(clone[j] + clone[k] + target < 0)
                {
                    int temp = j+1;
                    while(temp < n && clone[temp] == clone[j])
                    {
                        temp++;
                    }
                    j = temp;
                }
                else
                {
                    int temp = k-1;
                    while(temp >= 0 && clone[temp] == clone[k])
                    {
                        temp--;
                    }
                    k = temp;
                }
            }
            int t = i+1;
            while(t < n && clone[t] == clone[i])
            {
                t++;
            }
            i = t;
        }
        return ans;
    }
}