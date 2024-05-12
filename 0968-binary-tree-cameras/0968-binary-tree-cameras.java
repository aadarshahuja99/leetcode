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
    public int minCameraCover(TreeNode root) {
        HashMap<String,Integer> cache = new HashMap<>();
        return Math.min(getMinCameras(root, 0, 0, cache), getMinCameras(root, 1, 0, cache));
    }

    private int getMinCameras(TreeNode current, int hasCamera, int isCoveredByParent, HashMap<String,Integer> cache)
    {
        // similar intuition to house robber 3.
        // If a camera has not been placed at the current node and its parent, only then we can force one of the children to have cameras
        // In other cases, the both children have the choice of placing cameras at themselves
        if(current == null)
        {
            if(hasCamera == 1)
            {
                return 1001;
            }
            else
            {
                return 0;
            }
        }

        if(current.left == null && current.right == null)
        {
            if(hasCamera == 1)
            {
                return 1;
            }
            else if(isCoveredByParent == 1)
            {
                return 0;
            }
            return 1001;
        }
        
        String key = getKey(current, hasCamera, isCoveredByParent);

        if(cache.containsKey(key))
        {
            return cache.get(key);
        }

        if(hasCamera == 0 && isCoveredByParent == 0)
        {
            int leftChildForced = getMinCameras(current.left, 1, 0, cache) +
            Math.min(getMinCameras(current.right, 1, 0, cache), getMinCameras(current.right, 0, 0, cache));
            
            int rightChildForced = getMinCameras(current.right, 1, 0, cache) +
            Math.min(getMinCameras(current.left, 1, 0, cache), getMinCameras(current.left, 0, 0, cache));
            
            cache.put(key, Math.min(leftChildForced, rightChildForced));
        }

        else if(hasCamera == 1)
        {
            int left = Math.min(getMinCameras(current.left, 1, 1, cache), getMinCameras(current.left, 0, 1, cache));
            int right = Math.min(getMinCameras(current.right, 1, 1, cache), getMinCameras(current.right, 0, 1, cache));
            cache.put(key, 1 + left + right);
        }

        else
        {
            int left = Math.min(getMinCameras(current.left, 1, 0, cache), getMinCameras(current.left, 0, 0, cache));
            int right = Math.min(getMinCameras(current.right, 1, 0, cache), getMinCameras(current.right, 0, 0, cache));
            cache.put(key, left + right);
        }

        return cache.get(key);
    }

    private String getKey(TreeNode node, int hasCamera, int isCoveredByParent)
    {
        StringBuilder key = new StringBuilder(String.valueOf(node.hashCode()));
        key.append('_');
        key.append(hasCamera);
        key.append('_');
        key.append(isCoveredByParent);
        return key.toString();
    }
}