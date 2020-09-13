/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<int> InorderTraversal(TreeNode root) {
        var result = new List<int>();
        
        if (root == null){
            return result;
        }
        
        bool notLast = true;
        var nodeStack = new Stack<TreeNode>();
        
        nodeStack.Push(root);
        
        while (notLast)
        {
            var topNode = nodeStack.Peek();
            
            if (topNode.left != null)
            {
                nodeStack.Push(topNode.left);
                topNode.left = null;
            }
            else if (topNode.right != null)
            {
                nodeStack.Push(topNode.right);
                topNode.right = null;
            }
            else
            {
                result.Add(topNode.val);
                nodeStack.Pop();
            }
            
            notLast = nodeStack.Count > 0;
        }
        
        return result;
    }
}