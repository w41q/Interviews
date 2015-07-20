public class removeduplicatesfromsortedlist
{
	public static void main(String[] args)
	{
		int values[] = {3,3,5,5};
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
		if(pnt==null)
			System.out.println("null");
		else
		{
			System.out.println(pnt.val);
			while(pnt.next!=null)
			{
				pnt = pnt.next;
				System.out.println(pnt.val);
			}
		}
	}
	
	public static ListNode function(ListNode head)
    {
        // Round 2
        if(head==null || head.next==null)
            return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode pre = prehead, front = head, end = head.next;
        while(end!=null)
        {
            if(front.val==end.val)
            {
                while(end!=null && end.val==front.val)
                    end = end.next;
                pre.next = end;
                if(end==null)
                    break;
                else
                {
                	front = end;
                    end = end.next;
                }
            }
            else
            {
            	pre = front;
                front = end;
                end = end.next;
            }
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
