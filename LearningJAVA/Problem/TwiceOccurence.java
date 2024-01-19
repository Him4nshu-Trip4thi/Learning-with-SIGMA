/*
Question 1: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:
Input: nums = [1, 2, 3, 1]
Output: true
Example 2:
Input: nums = [1, 2, 3, 4]
Output: false
Example 3:
Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output: true
*/
public class TwiceOccurence
{
    public static boolean Occurence(int nums[])
    {
        int freq[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            freq[nums[i]]++;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(freq[i]>1)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String Args[])
    {
        int TC1[]={1,2,3,1};
        int TC2[]={1,2,3,4};
        int TC3[]={1,1,1,3,3,4,3,2,4,2};

        boolean TR1=Occurence(TC1);
        boolean TR2=Occurence(TC2);
        boolean TR3=Occurence(TC3);

        System.out.println(TR1);
        System.out.println(TR2);
        System.out.println(TR3);

    }
}