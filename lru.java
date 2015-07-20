import java.util.HashMap;
import java.util.Map;

public class lru
{
	public static void main(String[] agrs)
	{
		LRUCache l = new LRUCache(1);
		l.set(2,1);
		int a = l.get(2);
		l.set(3,2);
		a = l.get(2);
		a = l.get(3);
	}
	
	public static class LRUCache {
	    private Map<Integer, linkListNode> map;
	    private linkListNode head;
	    private linkListNode tail;
	    private int cap;
	    private int len;
	    
	    public LRUCache(int capacity)
	    {
	        map = new HashMap<Integer, linkListNode>();
	        this.cap = capacity;
	        len = 0;
	    }
	    
	    public int get(int key)
	    {
	        if(map.containsKey(key))
	        {
	            linkListNode node = map.get(key);
	            removeNode(node);
	            setHead(node);
	            return node.value;
	        }
	        else
	            return -1;
	    }
	    
	    public void set(int key, int value)
	    {
	        if(map.containsKey(key))
	        {
	            linkListNode node = map.get(key);
	            removeNode(node);
	            setHead(node);
	            node.value = value;
	        }
	        else
	        {
	            if(len<cap)
	            {
	                linkListNode node = new linkListNode(key, value);
	                setHead(node);
	                map.put(key, node);
	                len++;
	            }
	            else
	            {
	            	map.remove(tail.key);
	                removeNode(tail);
	                linkListNode node = new linkListNode(key, value);
	                setHead(node);
	                map.put(key, node);
	            }
	        }
	    }
	    
	    public void removeNode(linkListNode node)
	    {
	        if(node!=null)
	        {
	            linkListNode prev = node.prev, post = node.next;
	            if(prev!=null)
	                prev.next = post;
	            else
	                head = post;
	            if(post!=null)
	                post.prev = prev;
	            else
	                tail = prev;
	        }
	    }
	    
	    public void setHead(linkListNode node)
	    {
	        if(node!=null)
	        {
	            node.next = head;
	            node.prev = null;
	            if(head!=null)
	                head.prev = node;
	            head = node;
	            if(tail==null)
	                tail = node;
	        }
	    }
	    
	    public class linkListNode
	    {
	        public int key;
	        public int value;
	        public linkListNode prev;
	        public linkListNode next;
	        public linkListNode(int key, int value)
	        {
	            this.key = key;
	            this.value = value;
	            prev = null;
	            next = null;
	        }
	    }
	}
}