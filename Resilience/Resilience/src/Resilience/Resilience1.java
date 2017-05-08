package Resilience;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Resilience1
 {  
	private static String host;
	private static int port;

	public Resilience1(String message,int p)
	{
		this.host=message;
		this.port=p;
	}

     public static void main(String[] args)
	{  
          
	          
         try {
        	 
			Socket s=new Socket(host,port);
		
         
         
         
         } catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}  

}  
