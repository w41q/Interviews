import java.util.Arrays;

public class findMedianSortedArrays
{
	public static void main(String[] args)
	{
		int A[] = {3};
		int B[] = {1,2};
		double med = fmsa(A, B);
		System.out.println(med);
	}
	
	public static double fmsa(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        if ((lengthA + lengthB) % 2 == 0) {
            double r1 = (double) fmsa(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2);
            double r2 = (double) fmsa(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2 + 1);
            return (r1 + r2) / 2;
        } else
            return fmsa(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB + 1) / 2);
    }

    public static int fmsa(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        int n = endA - startA;
        int m = endB - startB;

        if (n <= 0)
            return B[startB + k - 1];
        if (m <= 0)
            return A[startA + k - 1];
        if (k == 1)
            return A[startA] < B[startB] ? A[startA] : B[startB];

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        if (A[midA] <= B[midB]) {
            if (n / 2 + m / 2 + 1 >= k)
                return fmsa(A, startA, endA, B, startB, midB, k);
            else
                return fmsa(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
        } else {
            if (n / 2 + m / 2 + 1 >= k)
                return fmsa(A, startA, midA, B, startB, endB, k);
            else
                return fmsa(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);

        }
    }
}