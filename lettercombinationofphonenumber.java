import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lettercombinationofphonenumber
{
	public static void main(String[] args)
	{
		String s = "23";
		List<String> list = letterCombinations(s);
	}
	
	public static List<String> letterCombinations(String digits)
    {
        String table[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char cha[] = digits.toCharArray();
        List<String> result = new ArrayList<String>();
        // for(int i=0;i<table[Integer.parseInt(""+cha[0])].length;i++)
        // {
        loopfunction(cha, 0, "", table, result);
        return result;
    }
    
    public static void loopfunction(char[] cha, int index, String pre, String[] table, List<String> result)
    {
        if(index==cha.length-1)
        {
            for(int i=0;i<table[Integer.parseInt(""+cha[index])].length();i++)
            {
                result.add(pre+table[Integer.parseInt(""+cha[index])].charAt(i));
            }
        }
        else
        {
            for(int i=0;i<table[Integer.parseInt(""+cha[index])].length();i++)
                loopfunction(cha, index+1, pre+table[Integer.parseInt(""+cha[index])].charAt(i), table, result);
        }
    }
}
