import java.util.*;
public class MaxAreaInHistogram{
    public static void maxArea(int arr[]){
        int maxArea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];

        //NextSmallerRight
        Stack <Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        //NextSmallerLeft
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=arr.length;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        
        //CurrentArea width=j-i-1=nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++){
            int h=arr[i];
            int w=nsr[i]-nsl[i]-1;
            int currArea=h*w;
            maxArea=Math.max(maxArea,currArea);
        }
        System.err.println("The maximum area of Histogram: "+maxArea);
    }


    public static void main (String Args[]){
        int arr[]={2,1,5,6,2,3};
        maxArea(arr);
    }
}