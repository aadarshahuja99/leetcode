class Solution {
    public int maximalRectangle(char[][] matrix) {
        // buildings logic
        int m = matrix.length;
        int n = matrix[0].length;
        int[] currentState = new int[n];
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == 0)
                {
                    currentState[j] = matrix[i][j] - 48;
                }
                else
                {
                    if(matrix[i][j] - 48 == 0)
                    {
                        currentState[j] = 0;
                    }
                    else
                    {
                        currentState[j] += matrix[i][j] - 48;
                    }
                }
            }
            // for(int h : currentState)
            // {
            //     System.out.print(h+" ");
            // }
            // System.out.println();
            // apply the largest area histogram logic here
            int currentMax = getLargestArea(currentState);
            ans = Math.max(ans, currentMax);
        }
        return ans;
    }
    private int getLargestArea(int[] histograms)
    {
        int numHistograms = histograms.length;
        int[] nsls = new int[numHistograms];
        int[] nsrs = new int[numHistograms];
        nsls[0] = -1;
        nsrs[numHistograms-1] = -1;
        Stack<Integer> nslStack = new Stack<>();
        nslStack.push(0);
        for(int i=1; i<numHistograms; i++)
        {
            int current = histograms[i];
            while(nslStack.size() > 0 && histograms[nslStack.peek()] >= current)
            {
                nslStack.pop();
            }
            if(nslStack.isEmpty())
            {
                nsls[i] = -1;
            }
            else
            {
                nsls[i] = nslStack.peek();
            }
            nslStack.push(i);
        }

        Stack<Integer> nsrStack = new Stack<>();
        nsrStack.push(numHistograms-1);
        for(int i=numHistograms-2; i>=0; i--)
        {
            int current = histograms[i];
            while(nsrStack.size() > 0 && histograms[nsrStack.peek()] >= current)
            {
                nsrStack.pop();
            }
            if(nsrStack.isEmpty())
            {
                nsrs[i] = -1;
            }
            else
            {
                nsrs[i] = nsrStack.peek();
            }
            nsrStack.push(i);
        }

        int maxArea = -1;
        for(int i=0; i<numHistograms; i++)
        {
            if(nsls[i] == -1 && nsrs[i] == -1)
            {
                // System.out.println("i: "+i+" "+(numHistograms) + " " + histograms[i]);
                maxArea = Math.max(maxArea, numHistograms*histograms[i]);
            }
            else
            {
                int length = 0;
                if(nsrs[i] == -1)
                {
                    length = (i - nsls[i] - 1) + (numHistograms - i);
                }
                else if(nsls[i] == -1)
                {
                    length = (i + 1) + (nsrs[i] - 1 - i);
                }
                else
                {
                    length = (i - nsls[i]) + (nsrs[i] - i - 1);
                }
                // System.out.println("length: "+length+" height "+histograms[i]+" left: "+nsls[i]+" right: "+nsrs[i]);
                maxArea = Math.max(maxArea, length*histograms[i]);
            }
        }
        return maxArea;
    }
}