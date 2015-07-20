public class singlenumber2{

     public static void main(String []args){
        int a[] = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        //int a[] = {-2,-2,-2,1};
        System.out.println(singleNumber(a));
     }
     
     public static int singleNumber(int[] A)
    {
        if(A==null || A.length==0)
            return 0;
        int count[] = new int[32];
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<32;j++)
            {
                int k = 1<<j;
                if((A[i]&k)!=0)
                {
                    count[j]++;
                }
            }
        }
        int result = 0;
        for(int i=0;i<32;i++)
        {
            if(count[i]%3!=0)
                result += 1<<i;
        }
        return result;
    }
}
