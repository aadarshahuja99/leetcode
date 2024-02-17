class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int height = (int)Math.floor((Math.log(label)/Math.log(2)));
        Integer[] ans = new Integer[height+1];
        if(height == 0)
        {
            ans[0]=1;
            return Arrays.asList(ans);
        }
        int level = height;
        int current = label;
        while(level > 0)
        {
            ans[level] = label;
            int levelStart = (int)Math.pow(2,level);
            int levelEnd = (int)Math.pow(2,level+1)-1;
            int parentEnd = levelStart-1;
            int parentStart = (int)Math.pow(2,level-1);
            int parentLength = parentEnd-parentStart+1;
            int expectedParentIndex = (label-levelStart)/2;
            int actualParent = parentStart + parentLength-1-expectedParentIndex;
            // System.out.println(levelStart+" "+parentEnd+" "+parentStart+" "+parentLength+" "+expectedParentIndex+" "+actualParent);
            level--;
            label = actualParent;
        }
        ans[0] = label;
        return Arrays.asList(ans);
    }
}