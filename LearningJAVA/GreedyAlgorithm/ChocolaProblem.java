import java.util.*;

public class ChocolaProblem {
    public static void main (String args[]){
        int n=4;
        int m=6;
        System.out.println("The matrix is of size "+m+"x"+n);
        Integer VerticalCost[]={2,1,3,1,4};
        Integer HorizontalCost[]={4,1,2};
        System.out.println("The minimum cost is: "+minCost(VerticalCost,HorizontalCost));
    }

    public static int minCost(Integer costVer[], Integer costHor[]){
        int cost=0;

        //Sorting-descending
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0, hp=1, vp=1;
        while(h<costHor.length && v<costVer.length){
            // VerticalCost < HorizontalCost
            if(costVer[v]<=costHor[h]){         //horizontal cut
                cost+=costHor[h]*vp;
                hp++;
                h++;
            }
            else{                               //vertical cut
                cost+=costVer[v]*hp;
                vp++;
                v++;
            }
        }

        while(v < costVer.length){
            cost+=costVer[v]*hp;
                vp++;
                v++;
        }

        while(v < costHor.length){
            cost+=costHor[h]*vp;
                hp++;
                h++;

        }
        return cost;
    }
}