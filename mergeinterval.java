import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mergeinterval
{
	public static void main(String[] args)
	{
		int[] start = {1,2}, end = {4,3};
		List<Interval> list = new ArrayList<Interval>();
		for(int i=0;i<start.length;i++)
		{
			Interval in = new Interval(start[i], end[i]);
			list.add(in);
		}
		List<Interval> result = function(list);
	}
	
	public static List<Interval> function(List<Interval> intervals)
	{
		List<Interval> result = new ArrayList<Interval>();
		if(intervals.size()==0)
			return result;
		Comparator<Interval> comp = new intcomp();
		Collections.sort(intervals, comp);
		result.add(intervals.get(0));
		for(int i=1;i<intervals.size();i++)
		{
			Interval prev = result.get(result.size()-1), next = intervals.get(i);
			
			if(prev.end>=next.start)
			{
				result.remove(result.size()-1);
				Interval newint = new Interval(prev.start, Math.max(prev.end, next.end));
				result.add(newint);
			}
			else
			{
				Interval newint = new Interval(next.start, next.end);
				result.add(newint);
			}
		}
		return result;
	}
	
	public static class intcomp implements Comparator<Interval>
	{
		public int compare(Interval i1, Interval i2)
		{
			if(i1.start > i2.start)
				return 1;
			else if(i1.start < i2.start)
				return -1;
			else
				return 0;
		}
	}
	
	public static class Interval
	{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
