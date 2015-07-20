public class populateNextPointer
{
	public static void main(String[] args)
	{
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		
		connect(n1);
	}
	
	public static void connect(TreeLinkNode root)
    {
        if(root==null || root.left==null)
            return;
        TreeLinkNode run = root;
        int count = 0;
        TreeLinkNode next = null;
        while(run!=null)
        {
            TreeLinkNode left = null, right = null;
            if(run.left!=null && run.right!=null)
                run.left.next = run.right;
            while(run!=null)
            {
                if(run.right!=null)
                {
                    left = run.right;
                    break;
                }
                if(run.left!=null)
                {
                    left = run.left;
                    break;
                }
                run = run.next;
            }
            if(run==null)
                break;
            if(count==0)
            {
            	next = left;
            	count++;
            }
            run = run.next;
            while(run!=null)
            {
                if(run.left!=null)
                {
                    right = run.left;
                    break;
                }
                if(run.right!=null)
                {
                    right = run.right;
                    break;
                }
                run = run.next;
            }
            if(left!=null)
                left.next = right;
            if(run==null)
                break;
            
            run = run.next;
        }
        connect(root.left);
    }
	
	public static class TreeLinkNode
	{
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}