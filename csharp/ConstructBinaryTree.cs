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
    private int preIndex = 0;
    
    private Dictionary<int, int> inorderValueIndexes = new Dictionary<int, int>();
    
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        //basic check
        if (preorder.Length == 0 || preorder.Length != inorder.Length)
        {
            return null;
        }
        
        //build our dictionary for easily getting index locations of values in the inorder array
        for (int i = 0; i < inorder.Length; ++i)
        {
            inorderValueIndexes.Add(inorder[i], i);
        }
        
        //call our algorithm function with initial values
        TreeNode root = BuildTreeAtIndex(ref preorder, ref inorder, 0, inorder.Length - 1);
        
        return root;
        
    }
    
    public TreeNode BuildTreeAtIndex(ref int[] preorder, ref int[] inorder, int startIndex, int endIndex){
        if (startIndex > endIndex)
        {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndex]);
        ++preIndex;
        
        //if start and end index is the same we know there are no child nodes
        if (startIndex == endIndex)
        {
            return node;
        }
        
        int inIndex = inorderValueIndexes[node.val];
        
        //all children to the left of our node
        node.left = BuildTreeAtIndex(ref preorder, ref inorder, startIndex, inIndex - 1);
        //all children to the right of our node
        node.right = BuildTreeAtIndex(ref preorder, ref inorder, inIndex + 1, endIndex);
        
        return node;
    }
}