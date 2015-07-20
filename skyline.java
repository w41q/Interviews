import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class skyline
{
	public static void main(String[] args)
	{
		int[][] building = new int[4][3];
		building[0][0] = 2; building[0][1] = 9; building[0][2] = 10;
		building[1][0] = 3; building[1][1] = 7; building[1][2] = 15;
		building[2][0] = 5; building[2][1] = 12; building[2][2] = 12;
		building[3][0] = 17; building[3][1] = 10; building[3][2] = 20;
		List<int[]> result = function(building);
	}
	
	public static List<int[]> function(int[][] buildings)
	{
		List<int[]> result = new ArrayList<int[]>();
		if(buildings.length==0 || buildings[0].length==0)
			return result;
		int len = buildings.length;
		List<Node> list = new ArrayList<Node>();
		for(int[] b : buildings)
		{
		    list.add(new Node(b[0], -b[2]));
		    list.add(new Node(b[1], b[2]));
		}
		Collections.sort(list, new PQsort());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(len+1, Collections.reverseOrder());
		q.offer(0);
		int prev = 0;
		for(Node n : list)
		{
		    if(n.height<0)
		        q.offer(-n.height);
            else
                q.remove(n.height);
            int curr = q.peek();
            if(curr!=prev)
            {
                result.add(new int[]{n.index, curr});
                prev = curr;
            }
		}
		return result;
	}
	
	public static class PQsort implements Comparator<Node>
	{
		public int compare(Node n1, Node n2)
		{
			return n1.index!=n2.index?n1.index-n2.index:n1.height-n2.height;
		}
	}
	
	public static class Node
	{
		public int height;
		public int index;
		public Node(int i, int h)
		{
			height = h;
			index = i;
		}
	}
}