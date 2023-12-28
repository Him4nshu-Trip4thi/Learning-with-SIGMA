import java.util.*;
public class CostBilling 
{
    public static void main (String Args[])
    {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Cost of Pencil : ");
        float pencil=sc1.nextFloat();
        Scanner sc2=new Scanner(System.in);
        System.out.println("Enter Cost of Pen : ");
        float pen=sc2.nextFloat();
        Scanner sc3=new Scanner(System.in);
        System.out.println("Enter Cost of Eraser : ");
        float eraser=sc3.nextFloat();

        double TotalCost=pen+pencil+eraser+(0.18*pen+0.18*pencil+0.18*eraser);
        System.out.println("The total Cost is : "+TotalCost);


    }
}
