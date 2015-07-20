public class cvtsortedlisttobst
{
	public static void main(String[] args)
	{
		int values[] = {1,3};
		ListNode l1 = new ListNode(values[0]);
		ListNode ll1;
		ll1 = l1;
		for(int i=1;i<values.length;i++)
		{
			ListNode ln = new ListNode(values[i]);
			ll1.next = ln;
			ll1 = ln;
		}

		ListNode pnt = l1;
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
		
		TreeNode result = function(l1);
//		pnt = result;
//		System.out.println("result:");
//		System.out.println(pnt.val);
//		while(pnt.next!=null)
//		{
//			pnt = pnt.next;
//			System.out.println(pnt.val);
//		}
	}
	
	public static TreeNode function(ListNode head)
	{
		if(head==null)
            return null;
        ListNode tr = head;
        int count = 0;
        while(tr!=null)
        {
            tr = tr.next;
            count++;
        }
        return loopfunc(head, 0, count-1);
    }
	
	public static TreeNode loopfunc(ListNode head, int begin, int end)
    {
        if(begin>end || head==null)
            return null;
        int mid = (begin+end)/2;
        //TreeNode left = loopfunc(head, begin, mid-1);
        ListNode tr = head;
        int k=begin;
        while(k<mid)
        {
            tr = tr.next;
            k++;
        }
        if(tr==null)
            return null;
        TreeNode t = new TreeNode(tr.val);
        t.left = loopfunc(head, begin, mid-1);
        t.right = loopfunc(tr.next, mid+1, end);
        return t;
    }
	
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
}
