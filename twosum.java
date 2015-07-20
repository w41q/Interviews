import java.util.HashMap;

public class twosum
{
	public static void main(String[] args)
	{
		int numbers[] = {3,2,4};
		int target = 6;
		HashMap hm = new HashMap();
		int result[] = new int[2];
		for(int i=0;i<numbers.length;i++)
		{
			if(hm.containsKey(target-numbers[i]))
			{
				int index = (int)hm.get(target-numbers[i]);
				result[0] = (i<index? i:index)+1;
				result[1] = (i>index? i:index)+1;
			}
			else
				hm.put(numbers[i], i);
		}
		System.out.println(result[0]+" "+result[1]);
	}
}
