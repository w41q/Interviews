import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordladder2
{
	public static void main(String[] argv)
	{
//		String start = "abc", end = "xyz";
//		String[] str = {"xbc","ayc"};
		String start = "red", end = "tax";
		String[] str = {"ted","tex","red","tax","tad","den","rex","pee"};
//		String start = "qa", end = "sq";
//		String[] str = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		
		Set<String> dict = new HashSet<String>();
		for(String s : str)
			dict.add(s);
		List<List<String>> result = function(start, end, dict);
		System.out.println(result);
	}
	
	public static List<List<String>> function2(String start, String end, Set<String> dict)
	{
		List<List<String>> res = new ArrayList<List<String>>();
        HashSet<String> unvisitedSet = new HashSet<String>();
        unvisitedSet.addAll(dict);
        unvisitedSet.add(start);
        unvisitedSet.remove(end);
        Map<String, List<String>> nextMap = new HashMap<String, List<String>>();
        for (String e : unvisitedSet)
            nextMap.put(e, new ArrayList<String>());
        LinkedList<StringWithLevel> queue = new LinkedList<StringWithLevel>();
        queue.add(new StringWithLevel(end, 0));
        boolean found = false;
        int finalLevel = Integer.MAX_VALUE;
        int curLevel = 0;
        int preLevel = 0;
        HashSet<String> visitedCurLevel = new HashSet<String>();
        while(!queue.isEmpty())
        {
            StringWithLevel cur = queue.poll();
            String curStr = cur.str;
            curLevel = cur.level;
            if(found && curLevel > finalLevel)
                break;
            if(curLevel > preLevel)
                unvisitedSet.removeAll(visitedCurLevel);
            preLevel = curLevel;
            char[] curStrCharArray = curStr.toCharArray();
            for(int i = 0; i < curStr.length(); ++i)
            {
                char originalChar = curStrCharArray[i];
                boolean foundCurCycle = false;
                for (char c = 'a'; c <= 'z'; ++c)
                {
                    curStrCharArray[i] = c;
                    String newStr = new String(curStrCharArray);
                    if(c != originalChar && unvisitedSet.contains(newStr))
                    {
                        nextMap.get(newStr).add(curStr);
                        if(newStr.equals(start))
                        {
                            found = true;
                            finalLevel = curLevel;
                            foundCurCycle = true;
                            break;
                        }
                        if(visitedCurLevel.add(newStr))
                            queue.add(new StringWithLevel(newStr, curLevel + 1));
                    }
                }
				if(foundCurCycle)
				    break;
                curStrCharArray[i] = originalChar;
            }
        }
        if(found)
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add(start);
            getPaths(start, end, list, finalLevel + 1, nextMap, res);
        }
        return res;
	}
	
	private static void getPaths(String cur, String end, ArrayList<String> list, int level, Map<String, List<String>> nextMap, List<List<String>> res)
    {
        if(cur.equals(end))
        {
            List<String> l = new ArrayList<String>(list);
            res.add(l);
        }
        else if(level > 0)
        {
            List<String> parentsSet = nextMap.get(cur);
            for (String parent : parentsSet)
            {
                list.add(parent);
                getPaths(parent, end, list, level - 1, nextMap, res);
                list.remove(list.size() - 1);
            }
        }
    }
	
	public static List<List<String>> function(String start, String end, Set<String> dict)
	{
		List<List<String>> result = new ArrayList<List<String>>();
        if(start.length()==0 || end.length()==0 || dict.size()==0 || start.equals(end))
            return result;
        List<String> q1 = new ArrayList<String>(), q2 = new ArrayList<String>();
        q1.add(start);
        Map<String, List<String>> parent = new HashMap<String, List<String>>();
        loopfunc(q1, q2, end, parent, dict);
        List<String> list = new ArrayList<String>();
        list.add(end);
        output(end, start, parent, list, result);
        return result;
	}
	
	public static void loopfunc(List<String> q1, List<String> q2, String end, Map<String, List<String>> parent, Set<String> dict)
    {
        if((q1.isEmpty() && q2.isEmpty()) || dict.isEmpty())
            return;
        Set<String> currLevel = new HashSet<String>();
        boolean flag = false;
        if(q1.isEmpty())
        {
            while(!q2.isEmpty())
            {
                String s = q2.remove(0);
                char[] cha = s.toCharArray();
                for(int i=0;i<cha.length;i++)
                {
                    char tmp = cha[i];
                    for(char c='a';c<='z';c++)
                    {
                        cha[i] = c;
                        String str = new String(cha);
                        if(str.equals(end))
                        {
                            flag = true;
                            if(parent.containsKey(str))
                                parent.get(str).add(s);
                            else
                            {
                                List<String> list = new ArrayList<String>();
                                list.add(s);
                                parent.put(str, list);
                            }
                            break;
                        }
                        if(c!=tmp && dict.contains(str))
                        {
                            if(parent.containsKey(str))
                                parent.get(str).add(s);
                            else
                            {
                                List<String> list = new ArrayList<String>();
                                list.add(s);
                                parent.put(str, list);
                            }
                            currLevel.add(str);
                            q1.add(str);
                        }
                    }
                    cha[i] = tmp;
                }
            }
        }
        else
        {
            while(!q1.isEmpty())
            {
                String s = q1.remove(0);
                char[] cha = s.toCharArray();
                for(int i=0;i<cha.length;i++)
                {
                    char tmp = cha[i];
                    for(char c='a';c<='z';c++)
                    {
                        cha[i] = c;
                        String str = new String(cha);
                        if(str.equals(end))
                        {
                            flag = true;
                            if(parent.containsKey(str))
                                parent.get(str).add(s);
                            else
                            {
                                List<String> list = new ArrayList<String>();
                                list.add(s);
                                parent.put(str, list);
                            }
                            break;
                        }
                        if(c!=tmp && dict.contains(str))
                        {
                            if(parent.containsKey(str))
                                parent.get(str).add(s);
                            else
                            {
                                List<String> list = new ArrayList<String>();
                                list.add(s);
                                parent.put(str, list);
                            }
                            currLevel.add(str);
                            q2.add(str);
                        }
                    }
                    cha[i] = tmp;
                }
            }
        }
        if(flag)
            return;
        dict.removeAll(currLevel);
        loopfunc(q1, q2, end, parent, dict);
    }
    
    public static void output(String s, String start, Map<String, List<String>> parent, List<String> pre, List<List<String>> result)
    {
        if(s.equals(start))
        {
            List<String> list = new ArrayList<String>();
            int size = pre.size();
            for(int i=size-1;i>=0;i--)
            	list.add(pre.get(i));
            if(!result.contains(list))
            	result.add(list);
            return;
        }
        if(!parent.containsKey(s))
            return;
        List<String> p = parent.get(s);
        for(String str : p)
        {
            pre.add(str);
            output(str, start, parent, pre, result);
            pre.remove(pre.size()-1);
        }
    }
    
    public static class StringWithLevel
    {
        String str;
        int level;
        public StringWithLevel(String str, int level)
        {
          this.str = str;
          this.level = level;
        }
    }
}