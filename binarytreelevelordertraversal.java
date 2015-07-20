import java.util.ArrayList;
import java.util.List;

public class binarytreelevelordertraversal{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		List<List<Integer>> result = levelOrder(a);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0 || preorder.length!=inorder.length)
            return null;
        TreeNode root = loopfunc2(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        return root;
    }
    
    public static TreeNode loopfunc2(int[] pre, int[] in, int prebegin, int preend, int inbegin, int inend)
    {
        if(prebegin>preend || inbegin>inend)
            return null;
        int idx = 0;
        while(inbegin+idx<=inend && in[inbegin+idx]!=pre[prebegin])
            idx++;
        if(inbegin+idx>inend)
            return null;
        TreeNode node = new TreeNode(pre[prebegin]);
        node.left = loopfunc2(pre, in, prebegin+1, prebegin+idx, inbegin, inbegin+idx-1);
        node.right = loopfunc2(pre, in, prebegin+idx+1, preend, inbegin+idx+1, inend);
        return node;
    }
	
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        List<TreeNode> queue1 = new ArrayList<TreeNode>(), queue2 = new ArrayList<TreeNode>();;
        queue1.add(root);
        loopfunc(queue1, queue2, result);
        return result;
    }
    
    public static void loopfunc(List<TreeNode> queue1, List<TreeNode> queue2, List<List<Integer>> result)
    {
        if(queue1.isEmpty() && queue2.isEmpty())
            return;
        else if(queue1.isEmpty())
        {
            List<Integer> list = new ArrayList<Integer>();
            while(!queue2.isEmpty())
            {
                TreeNode node = queue2.remove(0);
                if(node.left!=null) queue1.add(node.left);
                if(node.right!=null) queue1.add(node.right);
                list.add(node.val);
            }
            result.add(list);
            loopfunc(queue1, queue2, result);
        }
        else if(queue2.isEmpty())
        {
            List<Integer> list = new ArrayList<Integer>();
            while(!queue1.isEmpty())
            {
                TreeNode node = queue1.remove(0);
                if(node.left!=null) queue2.add(node.left);
                if(node.right!=null) queue2.add(node.right);
                list.add(node.val);
            }
            result.add(list);
            loopfunc(queue1, queue2, result);
        }
        else
            return;
    }
    
    
    
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
}