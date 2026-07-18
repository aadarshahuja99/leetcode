/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // brute force is n*(n-1)/2 calls and inefficient for large n
        // use stack for elimination phase and a 2nd phase for verification
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++)
        {
            st.push(i);
        }
        while(st.size() > 1)
        {
            int top = st.pop();
            int secondLast = st.pop();
            if(knows(top, secondLast))
            {
                st.push(secondLast);
            }
            else
            {
                st.push(top);
            }
        }
        int candidate = st.pop();
        for(int i=0; i<n; i++)
        {
            if(candidate == i)
            {
                continue;
            }
            if(!knows(i, candidate) || knows(candidate, i))
            {
                return -1;
            }
        }
        return candidate;
    }
}