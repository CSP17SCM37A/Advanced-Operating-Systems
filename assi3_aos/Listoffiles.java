import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Listoffiles
{
 
 public static void main(String[] args) 
{
	 System.out.println("Enter The directory name");
	 Scanner scan=new Scanner(System.in);
	 String path=scan.nextLine();
   
 
  String files;
  File folder = new File(path);
  File[] listOfFiles = folder.listFiles(); 
 
  for (int i = 0; i < listOfFiles.length; i++) 
  {
 
   if (listOfFiles[i].isFile()) 
   {
   files = listOfFiles[i].getName();
   System.out.println(files);
    }
  }
}
}