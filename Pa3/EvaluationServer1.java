import java.io.*;
import java.net.*;
import java.util.Scanner;
class ThreadHandler extends Thread
{
  
     
     Socket News1;
     int n;
 
     ThreadHandler(Socket s,int v)
     {
       News1=s;
       n=v;
     }

     public void run()
     { 
      try
        {  
       
        DataInputStream  inp1 = new DataInputStream(News1.getInputStream());
        DataOutputStream oup1 = new DataOutputStream(News1.getOutputStream()); 
        String fp = inp1.readLine();
        if(fp.equals("upload"))           
        {
             int filesize=266392;
	     int bytesRead;
	     int current = 0;                 
             BufferedReader inFromUser = new BufferedReader(new InputStreamReader( System.in));
             System.out.println("connected");
             byte [] buffer  = new byte [filesize];
       	     InputStream is = News1.getInputStream();	              
             FileOutputStream fos = new FileOutputStream("jay123.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos);                  
       	    // current = is.read(buffer,0,buffer.length);
            //current = bytesRead;
            // System.out.println(current);	       

       	     do 
             {  bytesRead =is.read(buffer);
	        // current, (buffer.length-current));
	        bos.write(buffer, 0 , bytesRead);
     	        System.out.println("file downloaded");
	         bos.flush();
		//if(bytesRead >= 0)
 		//current += bytesRead;
                 System.out.println("-------------------");
	          } while(bytesRead >=0);
                                
		//bos.write(buffer, 0 , current);
      		//System.out.println("file downloaded");
	        //bos.flush();	    				
       			     	       
                bos.close();

                }
                                 
       		      if(fp.equals("download"))
                       {
                          BufferedReader inFromClient = new BufferedReader(new InputStreamReader(News1.getInputStream()));

                  	  DataOutputStream outToClient = new DataOutputStream( News1.getOutputStream());
              
        
         		  String Dfile = inp1.readLine();
 			  File myFile = new File (Dfile);
 			  byte [] buffer  = new byte [(int)myFile.length()];
  			  FileInputStream fis = new FileInputStream(myFile);
  
 			  BufferedInputStream bis = new BufferedInputStream(fis);
  			  bis.read(buffer,0,buffer.length);
  
  			  OutputStream os = News1.getOutputStream();
  		          System.out.println("Sending...");
 			  os.write(buffer,0,buffer.length);
  			  os.flush();
                         
                          
                       }

          }
         catch(Exception e) 
        {
          System.out.println(e);
        }  
 
        
}       

    
}


class EvaluationServer1 {
public static void main(String args[]) throws Exception {  
           int req=101;
	   try	
	    {  

                System.out.println("Enter The port of tthe server:");
	 	Scanner x=new Scanner(System.in);
	 	String port2=x.nextLine();
                int port5 = Integer.parseInt(port2); 
             
               
               for(;;)
               { 
                       
                      ServerSocket welcomeSocket = new ServerSocket(port5);
                      Socket connectionSocket = welcomeSocket.accept();
        
                      System.out.println("I m the Client server:"); 
                      Thread T =new ThreadHandler(connectionSocket,req);
                      T.start();

                     req++;
               }

 	    }
          catch(Exception e) 
          {System.out.println(e);}  
        }  

}  

