class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] m1, int[] m2)
            {
                return m1[2] - m2[2];
            }
        });
        int i=0;
        DisjointSet ds = new DisjointSet(n);
        ds.union(0,firstPerson);
        while(i<meetings.length)
        {
            HashMap<Integer,HashSet<Integer>> adj = new HashMap<>();
            int j=i;
            int meetingTime = meetings[j][2];
            HashSet<Integer> set = new HashSet<>();
            while(j<meetings.length-1 && meetings[j][2] == meetings[j+1][2])
            {
                set.add(meetings[j][1]);
                set.add(meetings[j][0]);
                ds.union(meetings[j][0], meetings[j][1]);
                j++;
            }
            set.add(meetings[j][1]);
            set.add(meetings[j][0]);
            ds.union(meetings[j][0], meetings[j][1]);
            for(int person : set)
            {
                ds.resetParents(person);
            }
            i=j+1;
        }
        return ds.getAns();
    }

    class DisjointSet
    {
        int[] parent;
        int[] size;
        int n;
        public DisjointSet(int people)
        {
            n = people;
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
            Arrays.fill(size,1);
        }
        public int findParent(int u)
        {
            if(parent[u] == u)
            {
                return u;
            }
            return (parent[u] = findParent(parent[u]));
        }
        public void union(int u, int v)
        {
            int u_parent = findParent(u);
            int v_parent = findParent(v);
            if(u_parent == 0 && v_parent == 0)
            {
                return;
            }
            if(u_parent == 0)
            {
                parent[v_parent] = 0;
                size[0] += size[v_parent];
                return;
            }
            if(v_parent == 0)
            {
                parent[u_parent] = 0;
                size[0] += size[u_parent];
                return;
            }
            if(size[u_parent] >= size[v_parent])
            {
                parent[v_parent] = u_parent;
                size[u_parent] += size[v_parent];
            }
            else
            {
                parent[u_parent] = v_parent;
                size[v_parent] += size[u_parent];
            }
        }
        public void resetParents(int i)
        {
            int current_parent = findParent(i);
            if(current_parent != 0)
            {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public ArrayList<Integer> getAns()
        {
            var ans = new ArrayList<Integer>();
            for(int i=0; i<n; i++)
            {
                if(findParent(i) == 0)
                {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}