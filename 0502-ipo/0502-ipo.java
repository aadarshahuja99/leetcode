class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> doableProjects = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return b[1] - a[1];
            }
        });
        PriorityQueue<int[]> candidates = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });
        // candidates contains the projects that haven't been processed/marked as selectable. Once a project is selectable, we pop it from the candidates pq and add it to the doableProjects pq, then we greedily select the project with the highest profit from the doable projects
        int[][] elems = new int[profits.length][2];
        boolean canAnyProjectBeStarted = false;
        for(int i=0; i<profits.length; i++)
        {
            if(capital[i] <= w)
            {
                canAnyProjectBeStarted = true;
            }
            int[] newElement = new int[2];
            newElement[0] = capital[i];
            newElement[1] = profits[i];
            elems[i] = newElement;
        }
        if(!canAnyProjectBeStarted)
        {
            return 0;
        }
        for(int[] elem : elems)
        {
            candidates.add(elem);
        }
        int current = w;
        while(candidates.size() > 0 && k > 0)
        {
            while(candidates.size() > 0 && candidates.peek()[0] <= current)
            {
                doableProjects.add(candidates.poll());
            }
            if(doableProjects.size() == 0)
            {
                return current;
            }
            current += doableProjects.poll()[1];
            k--;
        }
        while(k > 0 && doableProjects.size() > 0)
        {
            current += doableProjects.poll()[1];
            k--;
        }
        return current;
    }
}