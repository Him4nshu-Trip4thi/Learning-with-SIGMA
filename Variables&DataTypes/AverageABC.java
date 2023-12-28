import java.util.*;
public class AverageABC
{
    public static void main (String Args[])
    {
        Scanner scA=new Scanner(System.in);
        int A=scA.nextInt();
        Scanner scB=new Scanner(System.in);
        float B=scB.nextFloat();
        Scanner scC=new Scanner(System.in);
        int C=scC.nextInt();
        float Average =(A+B+C)/3;
        System.out.println(Average);
    }
}