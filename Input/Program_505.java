import java.util.*;
import java.io.*;

class Program_505
{
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the file name that you want to see if it exists : ");
        String FileName = sobj.nextLine();

        try
        {
            File fobj = new File(FileName);
             
            boolean bRet = fobj.exists();
    
            if(bRet == true)
            {
                System.out.println("File exists.");
            }
            else
            {
                System.out.println("There is no such file.");
            }
            sobj.close();
        }
        catch(Exception iobj)
        {
            System.out.println("Exception occured : "+iobj);
        }
    }
}