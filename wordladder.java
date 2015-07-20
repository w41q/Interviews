import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordladder
{
	public static void main(String[] args)
	{
		String start = "cet", end = "ism";
		//String start = "hit", end = "cog";
		Set<String> dict = new HashSet<String>();
		String[] str = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
		//String[] str = {"hot","dot","dog","lot","log"};
		for(String s:str)
			dict.add(s);
		int result = function2(start, end, dict);
	}
	
	public static int function(String start, String end, Set<String> dict)
    {
		if(start==null || start.length()==0 || end==null || end.length()==0 || dict.size()==0 || start.equals(end))
            return 0;
        List<String> q = new ArrayList<String>();
        List<Integer> layer = new ArrayList<Integer>();
        q.add(start);
        layer.add(1);
        int count = 0;
        while(!q.isEmpty())
        {
            String s = q.remove(0);
            count = layer.remove(0);
            char[] cha = s.toCharArray();
            for(int i=0;i<s.length();i++)
            {
                //String pre = s.substring(0,i), rear = s.substring(i+1,s.length());
                char tmp = cha[i];
                for(char c='a';c<='z';c++)
                {
                    //String str = pre+c+rear;
                    cha[i] = c;
                    String str = new String(cha);
                    if(str.equals(end))
                        return count+1;
                    if(dict.contains(str)&&!str.equals(s))
                    {
                        q.add(str);
                        layer.add(count+1);
                    }
                    cha[i] = tmp;
                }
            }
        }
        return 0;
    }
	
	public static int function2(String start, String end, Set<String> dict)
	{
		if(start==null || start.length()==0 || end==null || end.length()==0 || dict.size()==0)
            return 0;
        if(start.equals(end))
            return 1;
        List<String> q1 = new ArrayList<String>(), q2 = new ArrayList<String>();
        q1.add(start);
        return loopfunc(end, q1, q2, dict, 1);
	}
	
	public static int loopfunc(String end, List<String> q1, List<String> q2, Set<String> dict, int level)
    {
        if(q1.isEmpty() && q2.isEmpty())
            return 0;
        else if(q1.isEmpty())
        {
            while(!q2.isEmpty())
            {
                String str = q2.remove(0);
                char[] cha = str.toCharArray();
                for(int i=0;i<cha.length;i++)
                {
                    char tmp = cha[i];
                    for(char c='a';c<='z';c++)
                    {
                        cha[i] = c;
                        String s = new String(cha);
                        if(s.equals(end))
                            return level+1;
                        if(dict.contains(s))
                        {
                            q1.add(s);
                            dict.remove(s);
                        }
                        cha[i] = tmp;
                    }
                }
            }
        }
        else if(q2.isEmpty())
        {
            while(!q1.isEmpty())
            {
                String str = q1.remove(0);
                char[] cha = str.toCharArray();
                for(int i=0;i<cha.length;i++)
                {
                    char tmp = cha[i];
                    for(char c='a';c<='z';c++)
                    {
                        cha[i] = c;
                        String s = new String(cha);
                        if(s.equals(end))
                            return level+1;
                        if(dict.contains(s))
                        {
                            q2.add(s);
                            dict.remove(s);
                        }
                        cha[i] = tmp;
                    }
                }
            }
        }
        return loopfunc(end, q1, q2, dict, level+1);
    }
}
