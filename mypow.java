import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class mypow
{
	public static void main(String[] args)
	{
		double result = function(0.00001,2147483647);
		System.out.println(result);
	}
	
	public static double function(double x, int n)
	{
		if(x==0)
            return 0;
        if(n==0)
            return 1;
        
        if(n>0)
        {
        	double h = function(x,n/2);
        	if(n%2==0)
                return h*h;
            else
                return h*h*x;
        }
        else
        {
        	double h = function(x,-n/2);
        	if(n%2==0)
                return 1/h/h;
            else
                return 1/h/h/x;
        }
        
	}
}
