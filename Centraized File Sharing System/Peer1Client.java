import java.io.*;  
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
  
class ThreadHandler1 extends Thread
{

Socket Newsock;
int port1;
ThreadHandler1(int v)
    {
     
     port1=v;
    }
 
   
  
public void run()
{
   
      
    try 
    {    
   
     ServerSocket cs=new ServerSocket(port1);
      Newsock=cs.accept();
      System.out.println("Connection Established");
  	  
     }
    catch(Exception e) 
   {System.out.println(e);} 
    
    
    

}

public class Peer1ent 
{  

   public static void main(String[] args)
   {  
	  int serverport;
          String filefind;
      try
        {  
            Scanner scanner = new Scanner(System.in);
                  
	         
     	    Socket s=new Socket("localhost",portNumber);
            System.out.println("Peer1 Intitialized");
            
            DataInputStream  inp = new DataInputStream(s.getInputStream());
            DataOutputStream oup = new DataOutputStream(s.getOutputStream());

             
             oup.writeBytes(x);
             oup.writeByte('\n');
             serverport = Integer.parseInt(x);
              // Crating thread for other peers to send requested file
             Thread T =new ThreadHandler1(serverport);
             T.start(); 

     	     String[] A = new String[20];
	         String FileName1=" ";
          
	       
	         System.out.println("Storing filenames in server index ....."); 
	         
	           
	        

	         oup.writeBytes(FileName1);
                 oup.writeByte('\n');
 	 
	         String filefinder;
	         
   		 
             System.out.println("Client: " + filefinder);
             oup.writeBytes(filefinder);
             oup.writeByte('\n');
				
                 
            
	         
             String Filepathinfo = inp.readLine();
	        
           
           

	 

        
	   
                     
            
    s.close(); 
   }
     catch(Exception e)
       { System.out.println(e); }  
   }

}
 


