import java.util.Stack;

class computeCompleteTreeNode
{
	public static void main(String[] argv)
	{
		TreeNode root = new TreeNode(1), left = new TreeNode(2), right = new TreeNode(3);
		root.left = left;
		root.right = right;
		System.out.println(function(root));
	}
	
	public static int function(TreeNode root)
	{
		if(root==null)
            return 0;
        if(root.left==null)
            return 1;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode run = root;
        int depth = 0;
        while(run!=null)
        {
            st.push(run);
            run = run.left;
            depth++;
        }
        st.pop();
        int count = 0, result = 0;
        while(!st.isEmpty())
        {
            TreeNode n = st.pop();
            count++;
            if(right(n)!=count)
            {
                result = (count-1)*2;
                if(findRight(n).left!=null)
                    result++;
                break;
            }
            else
            	result += count*2;
        }
        return (int)(Math.pow(2, depth-1)-1+result);
	}
	
	public static int right(TreeNode root)
    {
        if(root==null)
            return -1;
        int count = 0;
        TreeNode run = root;
        while(run.right!=null)
        {
            run = run.right;
            count++;
        }
        return count;
    }
    
    public static TreeNode findRight(TreeNode root)
    {
        if(root==null || root.right==null)
            return root;
        TreeNode run = root;
        while(run.right!=null)
            run = run.right;
        return run;
    }
	
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}