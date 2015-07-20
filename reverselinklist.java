public class reverselinklist
{
	public static void main(String[] args)
	{
		int values[] = {3,5};
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
		
		ListNode result = function(l1, 1, 2);
		pnt = result;
		System.out.println("result:");
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
	}
	
	public static ListNode function(ListNode head, int m, int n)
	{
		if(head==null)
            return null;
        int count = 1;
        ListNode fore = head, rear = head;
        while(count<m)
        {
            fore = fore.next;
            count++;
        }
        count = 1;
        while(count<n)
        {
            rear = rear.next;
            count++;
        }
        
        count = n-m;
        if(count==1)
        {
        	int tmp = fore.val;
            fore.val = rear.val;
            rear.val = tmp;
            return head;
        }
        while(fore.next!=rear && fore!=rear)
        {
            int num = 0;
            ListNode tr = fore;
            while(num<count)
            {
                tr = tr.next;
                num++;
            }
            int tmp = fore.val;
            fore.val = tr.val;
            tr.val = tmp;
            count -= 2;
            fore = fore.next;
        }
        return head;
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
