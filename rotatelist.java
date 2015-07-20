public class rotatelist
{
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(1);
		ListNode ll1;
		ll1 = l1;
		ListNode ln = new ListNode(2);
		ll1.next = ln;
		ll1 = ln;
		ListNode ln2 = new ListNode(3);
		ll1.next = ln2;
		ll1 = ln2;
		ListNode ln3 = new ListNode(4);
		ll1.next = ln3;
		ll1 = ln3;

		ListNode pnt = l1;
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
		
		ListNode result = function(l1, 8);
		pnt = result;
		System.out.println("result:");
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
	}
	
	public static ListNode function(ListNode head, int n)
	{
        ListNode tr = new ListNode(0);
        int count = 0;
        tr = head;
        while(tr!=null)
        {
            tr = tr.next;
            count++;
        }
        if(count==0 || count==1 || n%count==0)
            return head;
        if(count<n)
            n = n%count;
        int nodenum = count;
        tr = head;
        count = 0;
        ListNode newbegin = new ListNode(0);
        ListNode newtr = new ListNode(0);
        newtr = newbegin;
        while(count<n)
        {
            //tr = tr.next;
            count++;
        }
        while(count<nodenum)
        {
            ListNode ln = new ListNode(tr.val);
            newtr.next = ln;
            newtr = ln;
            count++;
            tr = tr.next;
        }
        count = 0;
        ListNode newhead = new ListNode(tr.val);
        tr = tr.next;
        newtr = newhead;
        while(tr!=null)
        {
            ListNode ln = new ListNode(tr.val);
            newtr.next = ln;
            newtr = ln;
            tr = tr.next;
        }
        newtr.next = newbegin.next;
        return newhead;
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
