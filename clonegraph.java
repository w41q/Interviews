import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class clonegraph
{
	public static void main(String[] args)
	{
		UndirectedGraphNode n1 = new UndirectedGraphNode(0);
		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
		UndirectedGraphNode n3 = new UndirectedGraphNode(2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n3);
		n3.neighbors.add(n3);
		UndirectedGraphNode nn = function(n1);
	}
	
	public static UndirectedGraphNode function(UndirectedGraphNode node)
	{
		if(node==null)
            return null;
        List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        list.add(node);
        HashMap<Integer, UndirectedGraphNode> hm = new HashMap<Integer, UndirectedGraphNode>();
        //hs.add(node.label);
        UndirectedGraphNode head = new UndirectedGraphNode(10);
        
        //head[0] = head0;
        int count = 0;
        while(list.size()!=0)
        {
            UndirectedGraphNode n = list.remove(0);
            if(!hm.containsKey(n.label))
            {
            	UndirectedGraphNode nn = new UndirectedGraphNode(n.label);
            	hm.put(n.label, nn);
                for(int i=0;i<n.neighbors.size();i++)
                {
                    if(!hm.containsKey(n.neighbors.get(i).label))
                    {
                        list.add(n.neighbors.get(i));
                        UndirectedGraphNode nnn = new UndirectedGraphNode(n.neighbors.get(i).label);
                        hm.put(nnn.label, nnn);
                        nn.neighbors.add(nnn);
                    }
                    else
                    {
                        UndirectedGraphNode nnn = hm.get(n.neighbors.get(i).label);
                        nn.neighbors.add(nnn);
                    }
                }
                if(count==0)
                {
                    //head[0].label = nn.label;
                    head = nn;
                    count++;
                }
            }
            else
            {
            	UndirectedGraphNode nn = hm.get(n.label);
                for(int i=0;i<n.neighbors.size();i++)
                {
                    if(!hm.containsKey(n.neighbors.get(i).label))
                    {
                        list.add(n.neighbors.get(i));
                        UndirectedGraphNode nnn = new UndirectedGraphNode(n.neighbors.get(i).label);
                        hm.put(nnn.label, nnn);
                        nn.neighbors.add(nnn);
                    }
                    else
                    {
                        UndirectedGraphNode nnn = hm.get(n.neighbors.get(i).label);
                        nn.neighbors.add(nnn);
                    }
                }
            }
        }
        return head;
    }
	
	public static class UndirectedGraphNode
	{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
	}
}
