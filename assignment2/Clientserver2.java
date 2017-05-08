import java.io.*;  
import java.net.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


class Hash
{
  
    public static int currentSize, maxSize;       
    public static  String keys;   
    public static String vals;    
   
    public static Hashtable<String,String> data=  new Hashtable<String,String>(1000001); 
    public  Hash() 
    {  currentSize = 0;
       keys = new String();
       vals = new String();
    }  
 
      
 
   void insert(String key, String val) 
    {                
        keys=key;
        vals=val;
        data.put(keys,vals);
      return;
       
    }
 
   
   public  String get(String Name){
       
             keys=Name;
	    return data.get(keys);
	}
 
    
   void delete(String key) 
    {
         keys=key;
        data.remove(keys);
        
          
    }       
 
    void printHashTable()
    {     System.out.println("Hash Table " );   
         Iterator<Entry<String, String>> it = data.entrySet().iterator();
    	    while (it.hasNext())
		     {
                    
       		    Entry<String, String> pair = it.next();
       		    System.out.println(pair.getKey() + " " + pair.getValue());  
       
   		     }

    }

   
}

class ThreadHandler extends Thread
{
  
     
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
        {   
           System.out.println("Thread created for peer" );
    	   Scanner scan = new Scanner(System.in);
           DataInputStream  inp = new DataInputStream(News.getInputStream());
           DataOutputStream oup = new DataOutputStream(News.getOutputStream());
            Hash h1 = new Hash();
 
              char ch;
              do    
             {
                          
            
            String ip = inp.readLine();
             int choice = Integer.parseInt(ip);           
            switch (choice)
            {
            case 1 : 
                String ip1 = inp.readLine();
                String ip2 = inp.readLine();
                h1.insert(ip1, ip2 );
                String ip15="Success";
                 oup.writeBytes(ip15);
                 oup.writeByte('\n'); 
                System.out.println("Key and values are inserted"); 
                 
                break;                          
                                  
            case 2 : 
                String ip3 = inp.readLine();
                 String ip11=(String) h1.get(ip3); 
                 if(ip11==null)
                  { String i26="Invalid Key";
                   oup.writeBytes(i26);
                  oup.writeByte('\n');}
                 else
                  {oup.writeBytes(ip11);
                  oup.writeByte('\n');}
                break;  
            case 3 :                 
                String ip4 = inp.readLine();
                h1.delete(ip4);
                 String ip18="Deleted"; 
                 oup.writeBytes(ip18);
                  oup.writeByte('\n');
                break;                                  
                 
            default : 
                System.out.println("Wrong Entry  ");
                break;   
            }
            
            
  
            
            String ctr = inp.readLine();
            ch = ctr.charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  

          h1.printHashTable();  
	                      
       // News.close();
        }
        
        catch(Exception e) 
        {System.out.println(e);}  
	
  }  
}



public class Clientserver2
 {  
     public static void main(String[] args)
	{  
           int req=1001;
	   try	
	    {  
               ServerSocket ss=new ServerSocket(7777); 
               
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

