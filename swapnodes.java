public class swapnodes
{
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(10);
		l1.next = l2;
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
		if(head==null)
            return null;
        ListNode tr = new ListNode(head.val);
        tr = head;
        int count =0;
        while(tr!=null)
        {
            count++;
            tr = tr.next;
        }
        if(count==1)
            return head;
        tr = head;
        ListNode parent = new ListNode(0), b = new ListNode(0), toreturn = new ListNode(head.val);
        if(count%2==0)
        {
            parent.next = head;
            b = head.next;
            toreturn = b;
            boolean flag = false;
            while(flag==false)
            {
                parent.next.next = b.next;
                b.next = parent.next;
                parent.next = b;
                
                parent = b.next;
                if(parent.next==null)
                    flag = true;
                else
                    b = parent.next.next;
            }
        }
        else
        {
            parent = head;
            toreturn = head;
            b = head.next.next;
            boolean flag = false;
            while(flag==false)
            {
                parent.next.next = b.next;
                b.next = parent.next;
                parent.next = b;
                
                parent = b.next;
                if(parent.next==null)
                    flag = true;
                else
                    b = parent.next.next;
            }
        }
        return toreturn;
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
