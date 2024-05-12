/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startsb = new StringBuilder();
        StringBuilder endsb = new StringBuilder();
        buildPath(root, startsb, startValue);
        buildPath(root, endsb, destValue);
        String startPath = startsb.toString();
        String endPath = endsb.toString();
        int idx = getUncommonIndex(startPath, endPath);
        if(idx == startPath.length())
        {
            return endPath.substring(idx, endPath.length());
        }
        StringBuilder upwards = new StringBuilder();
        for(int i=idx; i<startPath.length(); i++)
        {
            upwards.append('U');
        }
        if(idx == endPath.length())
        {
            return upwards.toString();
        }
        return upwards.toString() + endPath.substring(idx,endPath.length());
    }

    private int getUncommonIndex(String startPath, String endPath)
    {
        int i=0;
        int j=0;
        int n=endPath.length();
        int m=startPath.length();
        while(i < m && j < n && startPath.charAt(i) == endPath.charAt(j))
        {
            i++;
            j++;
        }
        return i;
    }

    private boolean buildPath(TreeNode root, StringBuilder path, int target)
    {
        if(root == null)
        {
            return false;
        }
        if(root.val == target)
        {
            return true;
        }
        path.append('L');
        boolean left = root.left != null ? buildPath(root.left, path, target) : false;
        if(left)
        {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        boolean right = root.right != null ? buildPath(root.right, path, target) : false;
        if(right)
        {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }
}