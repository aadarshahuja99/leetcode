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
    HashMap<Integer,Integer> map = new HashMap<>();
    int odd;
    int count;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        map.put(root.val,1);
        odd=1;
        dfs(root);
        return count;
    }
    private void dfs(TreeNode root)
    {
        if(root.left == null && root.right == null)
        {
            // System.out.println("odd count at leaf : "+root.val +" = "+odd);
            if(odd <= 1)
            {
                count++;
            }
            return;
        }
        if(root.left != null)
        {
            updateMap(root.left.val);
            dfs(root.left);
            map.replace(root.left.val, map.get(root.left.val) - 1);
            if(map.get(root.left.val)%2 != 0)
            {
                odd++;
            }
            else
            {
                odd--;
            }
        }
        if(root.right != null)
        {
            updateMap(root.right.val);
            dfs(root.right);
            map.replace(root.right.val, map.get(root.right.val) - 1);
            if(map.get(root.right.val)%2 != 0)
            {
                odd++;
            }
            else
            {
                odd--;
            }
        }
    }
    private void updateMap(int val)
    {
        if(map.containsKey(val))
        {
            map.replace(val,map.get(val)+1);
            if(map.get(val)%2 != 0)
            {
                odd++;
            }
            else
            {
                odd--;
            }
        }
        else
        {
            map.put(val,1);
            odd++;
        }
    }
}