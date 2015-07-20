import java.util.ArrayList;
import java.util.List;

public class regMatching
{
	public static void main(String[] args)
	{
		String s = "eaaad";
		String p = "ea*d";
		String sep[] = p.split("\\*");
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p)
	{
		if(s.isEmpty() && p.isEmpty())
            return true;
        if(!s.isEmpty() && p.isEmpty())
            return false;
        if(p.equals(".*"))
        	return true;
		
		char schar[] = s.toCharArray();
		char pchar[] = p.toCharArray();
		
		// 
		String psplit[] = p.split("\\*");
		for(int i=0;i<psplit.length;i++)
		{
			if(psplit[i].equals("") || psplit[i]==null)
				return false;
		}
		char repeater[];
		if(pchar[pchar.length-1]=='*')
			repeater = new char[psplit.length];
		else
			repeater = new char[psplit.length-1];
		for(int i=0;i<repeater.length;i++)
		{
			repeater[i] = psplit[i].charAt(psplit[i].length()-1);
			psplit[i] = psplit[i].substring(0, psplit[i].length()-1);
		}
		if(pchar[pchar.length-1]=='*')
			psplit[pchar.length-1] = psplit[pchar.length-1].substring(0, psplit[pchar.length-1].length()-1);
		
		List<ArrayList<int[]>> allPermutation = new ArrayList<ArrayList<int[]>>();
		for(int template=0;template<psplit.length;template++)
		{
			String currenttemplate = psplit[template];
			if(currenttemplate.length()==0)
				continue;
			ArrayList<int[]> al = new ArrayList<int[]>();
			
			int sbegin = 0, send = 0, t = 0;
			while(sbegin<=schar.length-1)
			{
				while(sbegin<=schar.length-1 && schar[sbegin]!=currenttemplate.charAt(t))
					sbegin++;
				if(sbegin+currenttemplate.length()-1 > schar.length-1)
				{
					if(al.size()==0)
						return false;
					else
						break;
				}
				if(currenttemplate.length()>1)
				{
					int cs = sbegin+1, cp = 1;
					while(cs<schar.length && cp<currenttemplate.length() && schar[cs]==currenttemplate.charAt(cp))
					{
						cs++; cp++;
					}
					if(cp != currenttemplate.length()-1)
						return false;
				}
				send = sbegin + currenttemplate.length() - 1;
				int position[] = new int[2];
				position[0] = sbegin;
				position[1] = send;
				al.add(position);
				sbegin++;
			}
			// update begin location
			allPermutation.add(al);
		}
		
//		ArrayList<int[]> possiblePermutation = new ArrayList<int[]>();
//		ArrayList<int[]> tempPermutation = new ArrayList<int[]>();
		List<ArrayList<int[]>> possiblePermutation = new ArrayList<ArrayList<int[]>>();
		// variable number of nested for loops
		// allPermutation -> possiblePermutation
		for(int i=0;i<allPermutation.get(0).size();i++)
		{
			ArrayList<int[]> permutation = new ArrayList<int[]>();
			permutation.add(allPermutation.get(0).get(i));
			fill1row(allPermutation, 0, permutation, possiblePermutation);
		}
		if(possiblePermutation.size()==0)
			return false;
		for(int i=0;i<possiblePermutation.size();i++)
		{
			if(pchar[pchar.length-1]=='*')
			{
				for(int j=0;j<possiblePermutation.get(i).size()-1;j++)
				{
					int gap = possiblePermutation.get(i).get(j+1)[0] - possiblePermutation.get(i).get(j)[1];
					for(int k=possiblePermutation.get(i).get(j)[1];k<possiblePermutation.get(i).get(j+1)[0];k++)
					{
						if(schar[k]!=repeater[i])
							return false;
					}
					for(int k=possiblePermutation.get(i).get(possiblePermutation.get(i).size()-1)[1];k<schar.length;k++)
					{
						if(schar[k]!=repeater[repeater.length-1])
							return false;
					}
				}
			}
			else
			{
				for(int j=0;j<possiblePermutation.get(i).size()-1;j++)
				{
					int gap = possiblePermutation.get(i).get(j+1)[0] - possiblePermutation.get(i).get(j)[1];
					for(int k=possiblePermutation.get(i).get(j)[1]+1;k<=possiblePermutation.get(i).get(j+1)[0]-1;k++)
					{
						if(schar[k]!=repeater[i])
							return false;
					}
				}
			}
			
				
		}
		return true;
	}
	
	public static void fill1row(List<ArrayList<int[]>> allPermutation, int level, ArrayList<int[]> ancestor, List<ArrayList<int[]>> possiblePermutation)
	{
		ArrayList<int[]> intervalList = allPermutation.get(level);
		if(level==allPermutation.size()-1)
		{
			for(int i=0;i<intervalList.size();i++)
			{
				if(intervalList.get(i)[0]>=ancestor.get(ancestor.size()-1)[1])
				{
					ancestor.add(intervalList.get(i));
					possiblePermutation.add(ancestor);
				}
			}
		}
		else
		{
			for(int i=0;i<intervalList.size();i++)
			{
				if(intervalList.get(i)[0]>=ancestor.get(ancestor.size()-1)[1])
				{
					ArrayList<int[]> newAncestor = new ArrayList<int[]>();
					for(int j=0;j<newAncestor.size();j++)
					{
						newAncestor.add(ancestor.get(j));
					}
					//ancestor.add(intervalList.get(i));
					fill1row(allPermutation, level+1, newAncestor, possiblePermutation);
				}
			}
		}
		
	}
}
