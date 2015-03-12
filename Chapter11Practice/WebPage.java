import java.util.Scanner;
import java.net.URL;
import java.io.PrintWriter;

public class WebPage throws malformedURLException
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the URL page, then the file you want to submit it to: ");
        
        String address = s.next();
        String newFile = s.next() + ".txt";
        URL pageLocation = new URL(address);
        PrintWriter out = new PrintWriter(newFile);    
        Scanner s2 = new Scanner(pageLocation.openStream());
        
        s2.useDelimiter(" ");
        while(s2.hasNext())
        {
            out.println(s2.next());
        }
        s2.close();
    }

}
