
public class addList
{
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(5), l2 = new ListNode(5);
		ListNode ll1, ll2;
		ll1 = l1;
		ll2 = l2;
		ListNode pnt = l2;
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
		
		ListNode result = addTwoNumbers(l1, l2);
		pnt = result;
		System.out.println("result:");
		System.out.println(pnt.val);
		while(pnt.next!=null)
		{
			pnt = pnt.next;
			System.out.println(pnt.val);
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
        ListNode l11 = new ListNode(l1.val), l22 = new ListNode(l2.val);
        l11.next = l1.next;
        l22.next = l2.next;
        
        int carry = 0;
        ListNode lnn = new ListNode((l1.val + l2.val)%10);
        ListNode ln = new ListNode(lnn.val);
        carry = (int)((l1.val + l2.val)/10);
        if(carry>0)
        {
        	ListNode ca = new ListNode(carry);
        	lnn.next = ca;
        }
        ln = lnn;
        
        while(l11.next!=null || l22.next!=null)
        {
            int a = 0, b = 0;
            if(l11.next!=null)
                a = l11.next.val;
            if(l22.next!=null)
                b = l22.next.val;
            int sum = a + b + carry;
            if(sum>=10)
            {
                carry = (int)(sum/10);
                sum = sum - 10;
            }
            else
                carry = 0;
            
            ListNode lnnn = new ListNode(sum);
            lnn.next = lnnn;
            lnn = lnnn;
            
            if(l11.next!=null)
            	l11 = l11.next;
            else
            {
            	ListNode zero = new ListNode(0);
            	l11 = zero;
            }
            if(l22.next!=null)
            	l22 = l22.next;
            else
            {
            	ListNode zero = new ListNode(0);
            	l22 = zero;
            }
        }
        if(carry!=0)
        {
        	ListNode lnnn = new ListNode(carry);
            lnn.next = lnnn;
            lnn = lnnn;
        }
        return ln;
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
