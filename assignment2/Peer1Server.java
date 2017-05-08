import java.io.*;  
import java.net.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;


class Hashtable
{
     public static int currentSize, maxSize;       
    public static  String[] keys;   
    public static String[] vals;    
 
    public  Hashtable(int capacity) 
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }  
 
   
    private static int hash(String key) 
    {
        return key.hashCode() % maxSize;
    }    
 
    public static void insert(String key, String val) 
    {                
        int tmp = hash(key);
        int i = tmp;
        do
        {
            if (keys[i] == null)
            {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                return;
            }
            if (keys[i].equals(key)) 
            { 
                vals[i] = val; 
                return; 
            }            
            i = (i + 1) % maxSize;            
        } while (i != tmp);       
    }
 
    
    public String get(String key) 
    {
        int i = hash(key);
        while (keys[i] != null)
        {
            if (keys[i].equals(key))
                return vals[i];
            i = (i + 1) % maxSize;
             
        }            
        return null;
    }
 
    
    public void delete(String key) 
    {
        if (!contains(key)) 
            return ;
 
        int i = hash(key);
        while (!key.equals(keys[i])) 
            i = (i + 1) % maxSize;        
        keys[i] = vals[i] = null;
 
        /** rehash all keys **/        
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize)
        {
            String tmp1 = keys[i], tmp2 = vals[i];
            keys[i] = vals[i] = null;
            currentSize--;  
            insert(tmp1, tmp2);            
        }
        currentSize--;  
          
    }       
 
    
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] +" "+ vals[i]);
        System.out.println();
    }
    public int getSize() 
    {
        return currentSize;
    }
    
 
    
    public boolean contains(String key) 
    {
        return get(key) !=  null;
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
            Hashtable h1 = new Hashtable(1000001 );
 
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
                 
                  String ip11=h1.get(ip3); 
                  if(ip11==null)
                  { String i26="Not Found";
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
            
            h1.printHashTable();  
  
            
            String ctr = inp.readLine();
            ch = ctr.charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  

           
	                      
       // News.close();
        }
        
        catch(Exception e) 
        {System.out.println(e);}  
	
  }  
}



public class Peer1Server
 {  
     public static void main(String[] args)
	{  
           int req=1001;
	   try	
	    {  
               ServerSocket ss=new ServerSocket(3333); 
               
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
