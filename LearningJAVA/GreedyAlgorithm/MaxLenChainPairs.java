import java.util.*;
public class MaxLenChainPairs {
    public static void main (String args[]){
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        System.out.println("The maximum length chain of pairs are: " + maxLenChain(pairs));
    }

    public static int maxLenChain(int pair[][]){
        //sorting the end time
        int arr[][]=new int [pair.length][3];
        for(int i=0;i<pair.length;i++){
            arr[i][0]=i;
            arr[i][1]=pair[i][0];
            arr[i][2]=pair[i][1];
        }

        Arrays.sort(arr,Comparator.comparingDouble(o->o[2]));

        int maxLen=1;
        int lastEnd=arr[0][2];
        ArrayList<Integer> res=new ArrayList<>();
        res.add(arr[0][0]);

        for(int i=1;i<pair.length;i++){
            if(arr[i][1]>=lastEnd){
                maxLen++;
                res.add(arr[i][0]);
                lastEnd=arr[i][2];
            }
        }
        for(int i=0;i<maxLen;i++){
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
        return maxLen;
    }
}
