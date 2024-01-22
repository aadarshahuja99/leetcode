class Solution {
    HashSet<Integer> visited = new HashSet<Integer>();
    LinkedList<Integer> ans = new LinkedList<Integer>();
    public List<Integer> circularPermutation(int n, int start) {
        visited.add(start);
        ans.addLast(start);
        compute(start,1,n);
        return new ArrayList<Integer>(ans);
    }
    private boolean compute(int current, int count, int n)
    {
        if(count == (int)Math.pow(2,n))
        {
            int last = ans.getLast();
            int first = ans.getFirst();
            int i=0;
            int diff = 0;
            while(i<n)
            {
                int mask = 1<<i;
                if((mask&first) != (mask&last))
                {
                    diff++;
                    if(diff>1)
                    {
                        return false;
                    }
                }
                i++;
            }
            return true;
        }
        for(int idx=0;idx<n;idx++)
        {
            boolean isSet = ((current)&(1<<idx)) > 0;
            int updated = current;
            if(isSet)
            {
                int mask = ~(1<<idx);
                updated = current&mask;
            }
            else
            {
                int mask = 1<<idx;
                updated = current|mask;
            }
            if(!visited.contains(updated))
            {
                visited.add(updated);
                ans.addLast(updated);
                if(!compute(updated,count+1,n))
                {
                    ans.removeLast();
                    visited.remove(updated);
                }
                else
                {
                    return true;
                }
            }
        }
        return false;
    }
}