import java.util.*;
public class IndianCoin {
    public static void main (String args[]){
        int coins[]={1,2,5,10,20,50,100,200,500,2000}; //infinite amount of these denominations
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value to get change: ");
        int v=sc.nextInt();
        sc.close();
        System.out.println("The minimum no. of coins that will be used for value " + v + " are: "+ findChange(coins,v));
    }

    public static int findChange(int coins[],int v){
        int count=0;
        // Arrays.sort(coins, Collections.reverseOrder());
        for(int i=coins.length-1;i>=0;i--){
            while(coins[i]<=v){
                count++;
                v-=coins[i];
                System.out.print(coins[i]+" ");
            }
        }
        System.out.println();
        return count;
    }
}
