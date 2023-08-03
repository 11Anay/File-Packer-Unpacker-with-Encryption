import java.util.*;
import java.io.*;

class Program_516
{
    public static void main(String arg[])
    {
        byte Buffer[] = new byte[1024];
        int iRet = 0;
        boolean bRet;
        int PackCount = 0;

        Scanner sobj = new Scanner(System.in);

        System.out.println("------------------- Marvellous Packer Unpacker --------------------");
        
        System.out.println("Packing Activity of the application is started...");

        System.out.println("Enter the folder name which contains the file that you want to pack : ");
        String FolderName = sobj.nextLine();
        
        File fobj = new File(FolderName);
        String Header = null;

        System.out.println("Enter the name of packed file that you want to create : ");
        String PackedFile = sobj.nextLine();

        sobj.close();

        try
        {
            File Packobj = new File(PackedFile);
            bRet = Packobj.createNewFile();
            if(bRet == false)
            {
                System.out.println("Unable to create a packed file.");
                return;
            }
            
            System.out.println("Packed file is getting successfully created in your current directory.");

            FileOutputStream outobj = new FileOutputStream(Packobj);

            bRet = fobj.isDirectory();
            if(bRet == true)
            {
                File list[] = fobj.listFiles();

                System.out.println("Total number of files found in the directory are : "+list.length);

                for(int i = 0; i < list.length; i++)
                {
                    if((list[i].getName().endsWith(".txt")))
                    {
                        Header = list[i].getName()+" "+list[i].length();
                        for(int j = Header.length(); j < 100; j++)
                        {
                            Header = Header + " ";
                        }
                        byte bHeader[] = Header.getBytes();

                        outobj.write(bHeader,0,bHeader.length);

                        FileInputStream inobj = new FileInputStream(list[i]);

                        //  Loop to write th data
                        while((iRet = inobj.read(Buffer)) != -1)
                        {
                            outobj.write(Buffer,0,iRet);
                        }

                        System.out.println("File successfully packed with name : "+list[i].getName());

                        inobj.close();
                        PackCount++;
                    }
                }
                System.out.println("-------------------- Packing Summary --------------------");
                System.out.println("Total number of files scanned : "+list.length);
                System.out.println("Total number of files packed : "+PackCount);

                System.out.println("Thank You for using Marvellous Packer Unpacker Unpacker");
            }
            outobj.close();     
        }
        catch(Exception iobj)
        {
            System.out.println("Exception occured : "+iobj);
        }
    }
}