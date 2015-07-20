public class sortlist
{
	public static void main(String[] args)
	{
		int values[] = {3,2,1,4};
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
		
		ListNode result = function2(l1);
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
        prehead.next = pre;
        int len = 0;
        while(pre!=null)
        {
        	len++;
        	pre = pre.next;
        }
        pre = prehead;
        ListNode slow = prehead.next, fast = prehead.next;
        for(int interval=1;interval<=len;interval*=2)
        {
        	pre = prehead;
        	slow = prehead.next;
        	fast = prehead.next;
        	while(slow!=null && fast!=null)
        	{
        		int i = 0;
        		while(i<interval && fast!=null)
        		{
        			fast = fast.next;
        			i++;
        		}
        		int fvisit = 0, svisit = 0;
        		while(fvisit<interval && svisit<interval && fast!=null && slow!=null)
        		{
        			if(fast.val<slow.val)
        			{
        				pre.next = fast;
        				pre = fast;
        				fast = fast.next;
        				fvisit++;
        			}
        			else
        			{
        				pre.next = slow;
        				pre = slow;
        				slow = slow.next;
        				svisit++;
        			}
        			while(fvisit<interval && fast!=null)
        			{
        				pre.next = fast;
        				pre = fast;
        				fast = fast.next;
        				fvisit++;
        			}
        			while(svisit<interval && slow!=null)
        			{
        				pre.next = slow;
        				pre = slow;
        				slow = slow.next;
        				svisit++;
        			}
        			pre.next = fast;
        			slow = fast;
        		}
        	}
        }
        return prehead.next;
    }
	
	public static ListNode function2(ListNode head)
	{
		if(head==null || head.next==null)
            return head;
        ListNode prehead = new ListNode(0), fast = prehead, slow = prehead;
        prehead.next = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
            if(fast!=null)
                fast = fast.next;
        }
        ListNode nexthead = slow.next;
        slow.next = null;
        ListNode left = function2(head);
        ListNode right = function2(nexthead);
        ListNode result = new ListNode(0), run = result;
        while(left!=null && right!=null)
        {
            if(left.val<right.val)
            {
                run.next = left;
                left = left.next;
            }
            else
            {
                run.next = right;
                right = right.next;
            }
            run = run.next;
            run.next = null;
        }
        while(left!=null)
        {
            ListNode node = new ListNode(left.val);
            run.next = node;
            run = run.next;
            left = left.next;
        }
        while(right!=null)
        {
            ListNode node = new ListNode(right.val);
            run.next = node;
            run = run.next;
            right = right.next;
        }
        return result.next;
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
