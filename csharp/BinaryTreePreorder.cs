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
    public IList<int> PreorderTraversal(TreeNode root) {
        var result = new List<int>();
        
        if (root == null){
            return result;
        }
        
        var nodeStack = new Stack<TreeNode>();
        
        nodeStack.Push(root);
        bool pop = false;
        
        while (nodeStack.Count > 0)
        {
            var topNode = nodeStack.Peek();
            
            if (!pop)
            {
                result.Add(topNode.val);
            }
            
            if (topNode.left != null)
            {
                nodeStack.Push(topNode.left);
                topNode.left = null;
                pop = false;
            }
            else if (topNode.right != null)
            {
                nodeStack.Push(topNode.right);
                topNode.right = null;
                pop = false;
            }
            else
            {
                nodeStack.Pop();
                pop = true;
            }
        }
        
        return result;
    }
}