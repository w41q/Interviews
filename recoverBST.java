import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recoverBST
{
	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(1);
		node1.right = node2;
		node2.left = node3;
		function(node1);
	}

	public static void function(TreeNode root)
    {
        if(root==null)
            return;
        List<TreeNode> list = new ArrayList<TreeNode>();
        find(root, list);
        if(list.size()==2)
        {
        	List<TreeNode> l1 = new ArrayList<TreeNode>(), l2 = new ArrayList<TreeNode>();
            TreeNode n1 = list.remove(0), n2 = list.remove(0);
            l1.add(n1);
            if(n1.left!=null)
                l1.add(n1.left);
            if(n1.right!=null)
                l1.add(n1.right);
            l2.add(n2);
            if(n2.left!=null)
                l2.add(n2.left);
            if(n2.right!=null)
                l2.add(n2.right);
            for(TreeNode node1 : l1)
            {
                for(TreeNode node2 : l2)
                {
                    swap(node1, node2);
                    if(valid(n1, n2))
                        return;
                    swap(node1, node2);
                }
            }
        }
        else if(list.size()==1)
        {
        	List<TreeNode> l1 = new ArrayList<TreeNode>();
            TreeNode n1 = list.remove(0);
            l1.add(n1);
            if(n1.left!=null)
                l1.add(n1.left);
            if(n1.right!=null)
                l1.add(n1.right);
            if(n1.left!=null && n1.right!=null)
            {
            	int[] a = new int[3];
            	a[0] = n1.left.val;
            	a[1] = n1.right.val;
            	a[2] = n1.val;
            	Arrays.sort(a);
            	n1.left.val = a[0];
            	n1.val = a[1];
            	n1.right.val = a[2];
            }
            else if(n1.left!=null)
            {
            	int min = Math.min(n1.val, n1.left.val), max = Math.max(n1.val, n1.left.val);
            	n1.left.val = min;
            	n1.val = max;
            }
            else if(n1.right!=null)
            {
            	int min = Math.min(n1.val, n1.right.val), max = Math.max(n1.val, n1.right.val);
            	n1.right.val = max;
            	n1.val = min;
            }
        }
    }
    
    public static void find(TreeNode root, List<TreeNode> list)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        else if(root.left==null)
        {
            if(root.val>root.right.val)
                list.add(root);
            find(root.right, list);
        }
        else if(root.right==null)
        {
            if(root.val<root.left.val)
                list.add(root);
            find(root.left, list);
        }
        else
        {
            if(!(root.left.val<root.val && root.val<root.right.val))
                list.add(root);
            find(root.left, list);
            find(root.right, list);
        }
    }
    
    public static void swap(TreeNode n1, TreeNode n2)
    {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
    
    public static boolean valid(TreeNode n1, TreeNode n2)
    {
        if(n1.left==null || (n1.left.val<n1.val))
        {
            if(n1.right==null || (n1.val<n1.right.val))
            {
                if(n2.left==null || (n2.left.val<n2.val))
                {
                    if(n2.right==null || (n2.val<n2.right.val))
                        return true;
                }
            }
        }
        return false;
    }
    
    public static class TreeNode
    {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}