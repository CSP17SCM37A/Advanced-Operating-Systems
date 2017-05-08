import java.io.*;  
import java.net.*; 
import java.io.DataInputStream;
import java.io.DataOutputStream; 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ThreadHandler extends Thread
{
  
 public static  HashMap<String,ArrayList<String>> fileInfo = new HashMap<String,ArrayList<String>>();
 public ArrayList<String> peerinfo = new ArrayList<String>();

    
  Socket News;
  int n;
 
   ThreadHandler(Socket s,int v)
    {
     News=s;
     n=v;
    }

  public void run()
  { 
      try
        {   System.out.println("Thread created for peer" );
    	     DataInputStream stdIn = new DataInputStream(System.in); 
             Scanner scanner = new Scanner(System.in);

             DataInputStream  ip = new DataInputStream(News.getInputStream());
                                
             DataOutputStream op = new DataOutputStream(News.getOutputStream());
             
	         String remoteIp =  News.getInetAddress().getHostAddress();
	         String RemotePort = ip.readLine();
             String peerId=Integer.toString(n);
         
	         // System.out.println("ip: " +remoteIp );
             // System.out.println("port: " + RemotePort );
             //System.out.println("Peerid: " +peerId );
             
             String path;
               
   	         path = ip.readLine();//accessing the file path in peer side
             
 	             
             String fromServer;
                 
   	        fromServer = ip.readLine();//accessing file names;
   	        // System.out.println(fromServer);      
              	             
                
   	        //Stroring peer details in hashmap
		
	         peerinfo .add(remoteIp);
	         peerinfo .add(RemotePort);
             peerinfo .add(peerId);
             peerinfo .add(path);
		
	          fileInfo.put(fromServer, peerinfo );

             Iterator it = fileInfo.entrySet().iterator();
    	     while (it.hasNext())
		     {
       		    Map.Entry pair = (Map.Entry)it.next();
       		    System.out.println(pair.getKey() + " = " + pair.getValue());  //Displaying key and values in hashmap
       
   		     }

             String fromclient = ip.readLine(); //fromclient is the file name to be search in index server.
             System.out.println(fromclient);
 
             int n=0;
	         
	         Iterator<Map.Entry<String,ArrayList<String>>> it1 = fileInfo.entrySet().iterator();
    	     while (it1.hasNext())
		     {
       			 Map.Entry<String,ArrayList<String>> pair = it1.next();
       			 
		         String files = pair.getKey();
			
		         if(files.contains(fromclient))
			      {
 			     	ArrayList<String> peerData = pair.getValue();
				
 			     	System.out.println(peerData.get(0));
				
 			     	op.writeBytes(peerData.get(0));
                    op.writeByte('\n');
                  	System.out.println(peerData.get(1));
			        op.writeBytes(peerData.get(1));
				    op.writeByte('\n');
                     op.writeBytes(peerData.get(3));
				    op.writeByte('\n');
			       
				    n++;
				
			   }
       

   		 }
       			
		if(n==0)
         {
            System.out.println("File not Found");
            String res="File not Found";
		    op.writeBytes(res);
	        op.writeByte('\n');
   	      } 
		
          // News.close();
        }
         catch(Exception e) 
            {System.out.println(e);}  
	
    }
}



public class CentralServer
 {  
     public static void main(String[] args)
	{  
           int req=1001; //Assigned for peerid
	   try	
	    {  
               ServerSocket ss=new ServerSocket(6666); //SCocket port 6666 
               
               for(;;)
               { 
                 Socket s=ss.accept();   //establishes connection  
                 System.out.println("Server started ");
                 Thread T =new ThreadHandler(s,req);
                 T.start();

                 req++;
               }

 	    }
          catch(Exception e) 
          {System.out.println(e);}  
        }  

}  
