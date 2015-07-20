
public class reorderlist
{
	public static void main(String[] args)
	{
		int values[] = {1,2,3};
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
		
		function3(l1);
		pnt = l1;
		System.out.println("result:");
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
	}
	
	public static void function(ListNode head)
    {
        if(head==null || head.next==null || head.next.next==null)
            return;
        ListNode end = head, mid = head;
        while(end.next!=null)
        {
            end = end.next;
            if(end.next==null)
                break;
            end = end.next;
            mid = mid.next;
        }
        
        ListNode prev = mid.next, next = prev.next, tmp = next;
		prev.next = null;
		while(next!=null)
		{
			tmp = next.next;
			next.next = prev;
			prev = next;
			next = tmp;
		}
		
		ListNode tr = head;
		while(prev!=null)
		{
		    tmp = prev.next;
		    prev.next = tr.next;
		    tr.next = prev;
		    prev = tmp;
		    tr = tr.next.next;
		}
		tr.next = null;
    }
	
	public static ListNode function2(ListNode head)
	{
		ListNode prev = head, next = prev.next;
		head.next = null;
		while(next!=null)
		{
			ListNode tmp = next.next;
			next.next = prev;
			prev = next;
			next = tmp;
		}
		return prev;
    }
	
	public static void function3(ListNode head)
	{
		if(head==null || head.next==null || head.next.next==null)
            return;
        ListNode tail = head, mid = head;
        while(tail.next!=null)
        {
            tail = tail.next;
            if(tail.next!=null)
            {
                tail = tail.next;
                mid = mid.next;
            }
        }
        ListNode prev = mid.next, next = prev.next;
        mid.next = null;
        prev.next = null;
        while(next!=null)
        {
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        
        ListNode run1 = head, run2 = prev;
        while(run2!=null)
        {
            ListNode tmp1 = run1.next, tmp2 = run2.next;
            run1.next = run2;
            run2.next = tmp1;
            run1 = tmp1;
            run2 = tmp2;
        }
        return;
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
