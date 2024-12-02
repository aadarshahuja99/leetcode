class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        // a car can collide with the next car as in Car Fleet 1
        // but it is possible that the next car has already collided with a slower car ahead of it 
        // in this case you will remove the next car from the top of the stack until you reach the slower car that defines the speed of the next car's fleet
        // It is also possible that the next car has not collided so far with its next car
        // In this case the current car, can directly collide with the next car and will not be added to the stack
        int n = cars.length;
        double[] ans = new double[n];
        ans[n-1] = -1.0;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for(int i=n-2; i >= 0; i--)
        {
            while(st.size() > 0)
            {
                int top = st.peek();
                int topSpeed = cars[top][1];
                int topPos = cars[top][0];
                if(topSpeed >= cars[i][1])
                {
                    st.pop();
                    continue;
                }
                double time = ((double)(topPos - cars[i][0]))/((double)(cars[i][1] - topSpeed));
                if(ans[top] == -1 || ans[top] >= time)
                {
                    ans[i] = time;
                    break;
                }
                else
                {
                    st.pop();
                }
            }
            if(st.size() == 0)
            {
                ans[i] = -1.0;
            }
            st.push(i);
        }
        return ans;
    }
}