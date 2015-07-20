public class partitionlist
{
	public static void main(String[] args)
	{
		int values[] = {1,4,3,2,5,2};
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
		
		ListNode result = function3(l1, 3);
		pnt = result;
		System.out.println("result:");
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
	}
	
	public static ListNode function(ListNode head, int x)
	{
		if(head==null)
            return null;
        ListNode fore = head;
        while(fore!=null && fore.val<x)
            fore = fore.next;
        if(fore==null)
            return head;
        ListNode rear = fore.next;
        while(rear!=null)
        {
            while(rear!=null && rear.val>=x)
                rear = rear.next;
            if(rear==null)
                return head;
            ListNode tr = fore;
            int tmp = rear.val;
            rear.val = fore.val;
            fore.val = tmp;
            tr = tr.next;
            while(tr!=rear)
            {
                tmp = rear.val;
                rear.val = tr.val;
                tr.val = tmp;
                tr = tr.next;
            }
            fore = fore.next;
        }
        return head;
    }
	
	public static ListNode function2(ListNode head, int x)
    {
        // Round 2
        if(head==null || head.next==null)
            return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode front = prehead, end = prehead;
        while(end!=null && end.next!=null)
        {
            if(end.next.val<x)
            {
            	if(front==end)
            	{
            		front = front.next;
            		end = end.next;
            	}
            	else
            	{
	                ListNode tmp = end.next.next;
	                end.next.next = front.next;
	                front.next = end.next;
	                end.next = tmp;
	                front = front.next;
            	}
            }
            else
            	end = end.next;
        }
        return prehead.next;
    }
	
	public static ListNode function3(ListNode head, int x)
	{
		if(head==null || head.next==null)
            return head;
        ListNode prehead = new ListNode(0), smallhead = new ListNode(0), run = prehead, run_small = smallhead;
        prehead.next = head;
        while(run.next!=null)
        {
            if(run.next.val<x)
            {
                run_small.next = run.next;
                run.next = run.next.next;
                run_small = run_small.next;
                run_small.next = null;
            }
            else
                run = run.next;
        }
        run_small.next = prehead.next;
        return smallhead.next;
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
