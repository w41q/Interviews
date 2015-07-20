public class insertionsortlist
{
	public static void main(String[] args)
	{
		int values[] = {2,1};
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
		
		ListNode result = function(l1);
		pnt = result;
		System.out.println("result:");
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
	}
	
	public static ListNode function(ListNode head)
	{
		if(head==null || head.next==null)
            return head;
        ListNode prehead = new ListNode(0), pre = head;
        prehead.next = head;
        while(pre!=null && pre.next!=null)
        {
            if(pre.val>pre.next.val)
            {
                ListNode small = pre.next;
                ListNode run = prehead;
                while(run.next.val<small.val)
                    run = run.next;
                ListNode tmp = small.next;
                small.next = run.next;
                run.next = small;
                pre.next = tmp;
            }
            else
                pre = pre.next;
        }
        return prehead.next;
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
