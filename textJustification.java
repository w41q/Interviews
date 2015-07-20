import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class textJustification
{
	public static void main(String[] args)
	{
		//String[] s = {"This", "is", "an", "example", "of", "text", "justification."};
		//String[] s = {"a","b","c","d","e"};
		//String[] s = {"Here","is","an","example","of","text","justification."};
		String[] s = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		List<String> result = function(s, 30);
		for(String str : result)
			System.out.println(str);
	}
	
	public static List<String> function(String[] words, int L)
	{
		List<String> result = new ArrayList<String>();
        if(words==null || words.length==0)
            return result;
        int idx = 0;
        while(idx<words.length)
        {
            int length = 0;
            List<Integer> list = new ArrayList<Integer>();
            while(idx<words.length && ((!list.isEmpty()&&length+words[idx].length()+1<=L)||(list.isEmpty()&&length+words[idx].length()<=L)))
            {
            	if(!list.isEmpty())
                	length++;
                list.add(idx);
                length += words[idx].length();
                idx++;
            }
            String line = "";
            if(idx==words.length)
            {
                for(int i : list)
                    line += words[i]+" ";
                line = line.substring(0, line.length()-1);
                if(L - line.length()>0)
                {
                    int space = L - line.length();
                    char[] cha = new char[space];
                    Arrays.fill(cha, ' ');
                    String str = new String(cha);
                    line = line + str;
                }
                result.add(line);
                break;
            }
            if(list.size()==1)
            {
                int space = L - length;
                char[] sp = new char[space];
                Arrays.fill(sp, ' ');
                String str = new String(sp);
                line = words[list.get(0)]+str;
            }
            else
            {
                int totalspace = L - length+list.size()-1;
                int[] space = new int[list.size()-1];
                Arrays.fill(space, totalspace/(list.size()-1));
                int leftspace = totalspace%(list.size()-1);
                for(int i=0;i<leftspace;i++)
                	space[i]++;
                String[] s = new String[list.size()-1];
                for(int i=0;i<s.length;i++)
                {
                    char[] cha = new char[space[i]];
                    Arrays.fill(cha, ' ');
                    String str = new String(cha);
                    s[i] = str;
                    line += words[list.get(i)] + str;
                }
                line += words[list.get(list.size()-1)];
            }
            result.add(line);
        }
        return result;
	}
}
