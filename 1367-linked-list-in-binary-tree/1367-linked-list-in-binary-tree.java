/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        // applying KMP algorithm. Naive method will be an O(n^2) method similar to subtree of another tree
        var list = getArrayFromLinkedList(head);
        var lps = computeLPSArray(list);
        return search(root, 0, list, lps);
    }

    private boolean search(TreeNode current, int currentIndexInList, ArrayList<Integer> list, int[] lps)
    {
        int lpsLength = lps.length;
        if(currentIndexInList == lpsLength)
        {
            return true;
        }
        if(current == null)
        {
            return false;
        }
        while(currentIndexInList > 0 && list.get(currentIndexInList) != current.val)
        {
            currentIndexInList = lps[currentIndexInList - 1];
        }
        if(list.get(currentIndexInList) == current.val)
        {
            currentIndexInList++;
        }
        return search(current.left, currentIndexInList, list, lps) || search(current.right, currentIndexInList, list, lps);
    }

    private ArrayList<Integer> getArrayFromLinkedList(ListNode head)
    {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current != null)
        {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }

    private int[] computeLPSArray(ArrayList<Integer> list)
    {
        int size = list.size();
        int[] lps = new int[size];
        int lastPrefixLength = 0;
        int index = 1;
        while(index < size)
        {
            if(list.get(index) == list.get(lastPrefixLength))
            {
                lps[index] = lastPrefixLength + 1;
                lastPrefixLength++;
                index++;
            }
            else if(lastPrefixLength == 0)
            {
                index++;
            }
            else
            {
                lastPrefixLength = lps[lastPrefixLength - 1];
            }
        }
        return lps;
    }
}