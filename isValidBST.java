public class isValidBST
{
	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		node1.right = node2;
		System.out.println(function(node1));
	}
	
	public static boolean function(TreeNode root)
	{
		if(root==null)
            return true;
        return loopfunc(root, (long)(Integer.MIN_VALUE)-1, (long)(Integer.MAX_VALUE)+1);
	}
	
	public static boolean loopfunc(TreeNode root, long min, long max)
    {
        if(root==null)
            return true;
        if((long)root.val<=(long)min || (long)root.val>=(long)max)
            return false;
        return loopfunc(root.left, min, root.val) && loopfunc(root.right, root.val, max);
    }
	
	public static class TreeNode
    {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}