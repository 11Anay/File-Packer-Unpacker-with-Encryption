import java.util.*;
import java.io.*;

class Program_521
{
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);
        byte Header[] = new byte[100];
        int iRet = 0;
        String HeaderStr;
        String Tokens[];
        int iCount = 0;

        System.out.println("------------------- Marvellous Packer Unpacker --------------------");
        System.out.println("UnPacking Activity of the application is started...");

        System.out.println("Enter the file name which contains the packed data : ");
        String PackedFile = sobj.nextLine();
        
        try
        {
            File Packobj = new File(PackedFile);
            FileInputStream inobj = new FileInputStream(Packobj);
            
            while((iRet = inobj.read(Header,0,100)) > 0)
            {
                HeaderStr = new String(Header);
                System.out.println(HeaderStr);
                
                Tokens = HeaderStr.split(" ");
                
                File newfileobj = new File(Tokens[0]);
                newfileobj.createNewFile();
                
                FileOutputStream outobj = new FileOutputStream(newfileobj);
                int FileSize = Integer.parseInt(Tokens[1]);
                byte Buffer[] = new byte[FileSize];
    
                inobj.read(Buffer, 0, FileSize);
                outobj.write(Buffer,0,FileSize);

                System.out.println("File successfully extracted with the name : "+Tokens[0]);
                iCount++;
                outobj.close();
            }
            System.out.println("-------------------- UnPacking Summary --------------------");
            System.out.println("Total number of files extracted : "+iCount);
            System.out.println("Thank you for using Marvellous Packer Unpacker..." );
            inobj.close();
        }
        catch(Exception iobj)
        {
            System.out.println("Exception occured : "+iobj);
        }
        sobj.close();
    }
}