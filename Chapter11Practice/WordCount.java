import java.util.Scanner;
import java.io.File;
public class WordCount
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("What is the file name: ");
        String fileName = s.next() + "txt." ;
        Scanner s2 = new Scanner(fileName);
        //does the reading from the textfile 
        s2.useDelimiter("");
        int s2int1 = 0;
        
        //counting characters
        while (s2.hasNext() )
        {
            char ch = s2.next().charAt(0);
            s2int1++;
        }
        
        System.out.println("Characters: " + s2int1);
        s2.useDelimiter(" ");
        int s2int2 = 0;
        
        //counting words
        while(s2.hasNext())
        {
            String word = s2.next().
            s2int2++;
        }
        
        System.out.println("Words: " + s2int2);
        s2.useDelimiter("\n");
        int s2int3 = 0;
        
        //counting lines
        while(s2.hasNext())
        {
            char ch = s2.next().charAt(0);
            s2int3++;
        }
        
        System.out.println("Lines: " + s2int3);
        
        s2.close();
    }
}

