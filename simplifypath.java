import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class simplifypath
{
	public static void main(String[] args)
	{
		String path = "/../home//wq/../a/b/../c";
		//String path = "/";
		System.out.println(function(path));
	}
	
	public static String function(String path)
	{
		if(path.length()==0)
			return "";
		List<String> list = new ArrayList<String>();
		String folder[] = path.split("/");
		for(int i=0;i<folder.length;i++)
		{
			String f = folder[i];
			if(f.isEmpty())
				continue;
			if(f.equals(".."))
			{
				if(list.isEmpty())
					continue;
				else
					list.remove(list.size()-1);
			}
			else
				list.add(f);
		}
		String result = "";
		while(!list.isEmpty())
		{
			result += "/"+list.remove(0);
		}
		if(result.length()==0)
			return "/";
		else
			return result;
	}
}
