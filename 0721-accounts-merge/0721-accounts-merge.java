class Disjoint{
    int[] parent;
    int[] size;
    Disjoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }
    public int find(int u){
        return parent[u] = parent[u] == u ? u : find(parent[u]);
    }
    public void union(int u,int v){
        int uPar = find(u);
        int vPar = find(v);
        if(size[uPar] >= size[vPar])
        {
            size[uPar] += size[vPar];
            parent[uPar] = vPar;
        }
        else
        {
            size[vPar] += size[uPar];
            parent[vPar] = uPar;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        Disjoint ds= new Disjoint(n);
        Map<String,Integer> h= new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String temp= accounts.get(i).get(j);
                if(!h.containsKey(temp)){
                    h.put(temp,i);
                }else{
                    ds.union(i,h.get(temp));
                }
            }
        }
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();
        for (Map.Entry<String, Integer> it : h.entrySet()) {
            String mail = it.getKey();
            int node = ds.find(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans= new ArrayList<>();
         for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}