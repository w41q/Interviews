public class reverseKGroup
{
	public static void main(String[] args)
	{
		int[] value = {1,2};
		ListNode list = new ListNode(value[0]);
		ListNode tail = list;
		for(int i=1;i<value.length;i++)
		{
			ListNode node = new ListNode(value[i]);
			tail.next = node;
			tail = tail.next;
		}

		ListNode pnt = list;
		while(pnt!=null)
		{
			System.out.println(pnt.val);
			pnt = pnt.next;
		}
		
		ListNode result = function(list, 2);
		pnt = result;
		System.out.println("result:");
		while(pnt!=null)
		{
			System.out.println(pnt.val);
			pnt = pnt.next;
		}
	}
	
	public static ListNode function(ListNode head, int k)
	{
		if(head==null || head.next==null || k<=1)
            return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode left = prehead, right = left;
        while(left!=null && right!=null)
        {
            int count = 0;
            while(right!=null && count<k)
            {
                right = right.next;
                count++;
            }
            if(right==null)
                break;
            while(left.next!=right)
            {
                ListNode tmp = left.next;
                left.next = left.next.next;
                tmp.next = right.next;
                right.next = tmp;
            }
            count = 0;
            while(left!=null && count<k)
            {
                left = left.next;
                count++;
            }
            if(left==null)
                break;
            right = left;
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
