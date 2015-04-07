import java.util.Arrays;
public class SelectionSorter
{
    public static void sort(int[] a)
    {
        // repeatedly scan the unsorted portion of the array for the next smallest value 
        // and swap it with the element as the beginning of the unsorted portion of the array
        
        for(int i = 0; i < a.length - 1; i++)
        {
            int largestValue = a[i];
            int indexOfLargestValue = i;
            
            // scan through the unsorted portion of the array and find the
            // smallest value; update the smallest value and the index of 
            // that element
            for(int j = i; j < a.length; j++)
            {
                if( a[j] > largestValue )
                {
                    largestValue = a[j];
                    indexOfLargestValue = j;
                }
            }
            
            //swap the smallest value with the element at the beginning of the 
            // unsorted portion of the array
            int temp = a[i];
            a[i] = a[indexOfLargestValue];
            a[indexOfLargestValue] = temp;
        }
    }
    
    public static void main(String[] args)
    {
        int[] a = new int[20];
        for(int i = 0; i<a.length; i++)
        {
            a[i] = (int)(Math.random() * 100);
            
        }
        
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}