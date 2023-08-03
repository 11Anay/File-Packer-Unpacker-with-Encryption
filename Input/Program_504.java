import java.util.*;
import java.io.*;

class Program_504
{
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the file name you want to create : ");
        String FileName = sobj.nextLine();

        try
        {
            File fobj = new File(FileName);
             
            boolean bRet = fobj.createNewFile();
    
            if(bRet == true)
            {
                System.out.println("File created successfully.");
            }
            else
            {
                System.out.println("Unable to create a file.");
            }
            sobj.close();
        }
        catch(IOException iobj)
        {
            System.out.println("Exception occured : "+iobj);
        }
    }
}