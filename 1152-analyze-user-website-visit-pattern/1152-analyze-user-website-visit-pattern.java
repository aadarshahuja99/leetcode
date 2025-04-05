class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = username.length;
        HashMap<String,List<Data>> userVisits = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            if(!userVisits.containsKey(username[i]))
            {
                userVisits.put(username[i], new ArrayList<>());
            }
            userVisits.get(username[i]).add(new Data(timestamp[i], website[i]));
        }
        for(String u : userVisits.keySet())
        {
            Collections.sort(userVisits.get(u), (a, b) -> {
                return a.t - b.t;
            });
            var set = generate(userVisits.get(u));
            for(String s : set)
            {
                map.put(s, map.getOrDefault(s,0) + 1);
            }
        }
        int max = 0;
        String ans = "";
        for(var entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                ans = entry.getKey();
            }
            else if(entry.getValue() == max && entry.getKey().compareTo(ans) < 0)
            {
                ans = entry.getKey();
            }
        }
        // System.out.println(ans);
        String[] arr = ans.split(",");
        ArrayList<String> finalAns = new ArrayList<>();
        for(String node : arr)
        {
            finalAns.add(node);
        }
        return finalAns;
    }
    private Set<String> generate(List<Data> data)
    {
        int len = data.size();
        HashSet<String> vis = new HashSet<>();
        for(int i=0; i<=len-3; i++)
        {
            for(int j=i+1; j<=len-2; j++)
            {
                for(int k=j+1; k<=len-1; k++)
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(data.get(i).w);
                    sb.append(',');
                    sb.append(data.get(j).w);
                    sb.append(',');
                    sb.append(data.get(k).w);
                    var str = sb.toString();
                    vis.add(str);
                }
            }
        }
        return vis;
    }
    class Data
    {
        int t;
        String w;
        Data(int ti, String we)
        {
            t = ti;
            w = we;
        }
    }
}