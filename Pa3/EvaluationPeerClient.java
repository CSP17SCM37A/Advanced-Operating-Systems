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

class Hashtableop
{
    private int  maxSize;       
    private String[] keys;   
    public Hashtableop(int capacity) 
    {
        
        maxSize = capacity;
        keys = new String[maxSize];
        
    }  
 
    private int hash(String key) 
    {
         return key.hashCode() % maxSize;
    }    
 
    public int find(String key) 
    {                
          int tmp = hash(key);
          return tmp;
    }   
    
}



 
class EvaluationPeerClient {
    public static void main(String args[])
        {     
             try 
              {

                 Scanner scan = new Scanner(System.in);
                 Hashtableop Serverslct = new Hashtableop(8); 
                 System.out.println("Enter key to connect server:");
                 int n=Serverslct.find(scan.next());
                 if (n < 0)
                  n = -n;
                 System.out.println("connecting to the server "+n);
                 int k=0;
                
                 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Config.txt")));         
                 String Peerdetls; 
       		 String line;
       		 while ((line = br.readLine()) != null) 
                 {
                    
                  
                  if(n==k)
                  {
                    Peerdetls=line;
                    String words[] = Peerdetls.split(" ");
                    // String firstTwo = words[0] + "  " + words[1]; 
                    System.out.println(words[0]);
                    System.out.println(words[1]);
                    
                    int port = Integer.parseInt(words[1]);
                     Socket s=new Socket(words[0],port);
                     System.out.println("Peer1 Intitialized");
                     DataInputStream  inp = new DataInputStream(s.getInputStream());
                     DataOutputStream oup = new DataOutputStream(s.getOutputStream());
                    
                    char ch;
      		  
		     do    
        		{
           		  System.out.println("\nHash Table Operations\n");
            		  System.out.println("1. Register ");
            		  System.out.println("2. Search & Download");
                         
            		              
                          System.out.println("Enter the Choice:");
           		 int choice = scan.nextInt(); 
                         String choice1 = Integer.toString(choice);
                         oup.writeBytes(choice1);
                         oup.writeByte('\n');
                         int i;
			 String tokens[] = null;
           		 String[] tokens1=null;
 	          
            		 switch (choice)
            		 {
            		  case 1 : 
                		        System.out.println("Register:");
                                        System.out.println("Enter The file name");
	 				Scanner x=new Scanner(System.in);
	 				String path=x.nextLine();
    					String files;
                                        String fileinfo=words[0]+" "+port+" "+path;
                                       



                                long millis = System.currentTimeMillis() % 1000; 
                                 for( i=10000;i<20000;i++)
                		  {     String path1=i+path;
                                        oup.writeBytes(path1);
                                 	oup.writeByte('\n');
                                        oup.writeBytes(fileinfo);
                                        oup.writeByte('\n');
                                   }
                                 long millis1 = System.currentTimeMillis() % 1000;
                                 long Registertime=millis1-millis;  
                                 System.out.println("Time required to register 10k files"+Registertime); 
                                   String ip21 = inp.readLine();
                                     System.out.println(ip21);

 				       /* File folder = new File(path);
  					File[] listOfFiles = folder.listFiles(); 

                                        int z=listOfFiles.length;
					String str1 = Integer.toString(z);
                                        oup.writeBytes(str1);
                                 	oup.writeByte('\n');

  					for (i = 0; i < z; i++) 
  					{
 
  					   if (listOfFiles[i].isFile()) 
   					   {
   						files = listOfFiles[i].getName();
  						 oup.writeBytes(files);
                                 	         oup.writeByte('\n');
                                                 oup.writeBytes(fileinfo);
                                                 oup.writeByte('\n');
   					   }
  					}*/
                                      


                                      /* Socket r=new Socket(words[0],port+1111);
                                       System.out.println("Peer1 sending file....");
                                       DataInputStream  inp2 = new DataInputStream(r.getInputStream());
                                       DataOutputStream oup2 = new DataOutputStream(r.getOutputStream()); 
                                       String save="upload";
                                       oup2.writeBytes(save);
                                       oup2.writeByte('\n'); 
                                       File myFile = new File (path);
  				       byte [] buffer1  = new byte [(int)myFile.length()];
 				       FileInputStream fis = new FileInputStream(myFile);
                                       BufferedInputStream bis = new BufferedInputStream(fis);
 				       bis.read(buffer1,0,buffer1.length);
  
  				       OutputStream os = r.getOutputStream();
 				       System.out.println("Sending...");
 				       os.write(buffer1,0,buffer1.length);
 				       os.flush();
 				       r.close(); */
                                      
                                       break;   

                            case 2 :  
                                     System.out.println("Enter filename to be search:");
                                     String fname=scan.next();
                                      long millis2 = System.currentTimeMillis() % 1000; 
                                 for( i=10000;i<20000;i++)
                		  {    String fname9=i+fname;
                                      oup.writeBytes(fname9);
                                       oup.writeByte('\n');
                                      String ip6 = inp.readLine();
                                      System.out.println("file details = "+ip6 );
                                   }
                                 long millis3 = System.currentTimeMillis() % 1000;
                                 long searchtime=millis3-millis2;  
                                 System.out.println("Time required to search 10k files :"+searchtime); 
                                     

                                     String ip6 = inp.readLine();
 				     if(ip6.equals("FileNotFound"))
                                     {
                                      System.out.println(ip6);
                                     }
                                     else
                                     {
                                      System.out.println("Value = "+ip6 );
				    
				      String phrase = ip6;
				      String delims = "[ ]+";
				
				      tokens1 = phrase.split(delims);
				      for ( i = 0; i < tokens1.length; i++)
    				      {   }
                                 
			             
                                      int filesize=266392;
				      int bytesRead;
				      int current = 0;

				              
                                      System.out.println(tokens1[0]);
				      System.out.println(tokens1[1]);
                                      System.out.println(tokens1[2]);
                                      long millis4 = System.currentTimeMillis() % 1000;
                                         
                                      if(port== Integer.parseInt(tokens1[1]))
                                      {
                                        for( i=10000;i<20000;i++){
                                       oup.writeBytes(tokens1[2]);
                                       oup.writeByte('\n');
                                       BufferedReader inFromUser = new BufferedReader(new InputStreamReader( System.in));
                                       System.out.println("connecting");
			               byte [] buffer  = new byte [filesize];
       			               InputStream is = s.getInputStream();

        			       FileOutputStream fos = new FileOutputStream("F2/");
        			       BufferedOutputStream bos = new BufferedOutputStream(fos);

                                 
       					// current = is.read(buffer,0,buffer.length);
        			 	//current = bytesRead;
                                	// System.out.println(current);
                                
       				       do {  
					  bytesRead =is.read(buffer);
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
                                      
                                          long millis6 = System.currentTimeMillis() % 1000;
                                          long obtaintime=millis6-millis4;  
                                          System.out.println("Time required to Obtain 10k files :"+obtaintime);

                                }
                                else
                               {
				Socket clientSocket = new Socket(tokens1[0], Integer.parseInt(tokens1[1]));
			        System.out.println("connecting");   
                                oup.writeBytes("download");
                                oup.writeByte('\n');
                                oup.writeBytes(tokens1[2]);
                                oup.writeByte('\n');
                                BufferedReader inFromUser = new BufferedReader(new InputStreamReader( System.in));
                                System.out.println("connecting");
		                byte [] buffer  = new byte [filesize];
       			        InputStream is = s.getInputStream();

       			        FileOutputStream fos = new FileOutputStream("wassupp.class");
       			        BufferedOutputStream bos = new BufferedOutputStream(fos);
                                 
       				// current = is.read(buffer,0,buffer.length);
        		        //current = bytesRead;
                                // System.out.println(current);
                                
       			        do {  
				bytesRead =is.read(buffer);
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
                                 clientSocket.close();
 
                               }
                              }
                                  break; 
    

           		  default : 
                		   System.out.println("Wrong Entry  ");
                		   break;   
                           }
            
                       
            System.out.println("Do you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);   
             String str = Character.toString(ch);
             oup.writeBytes(str);
             oup.writeByte('\n');                     
        } while (ch == 'Y'|| ch == 'y'); 

       }
      k++;  
      }

     br.close();
              
      } 
 
     catch (Exception e)
     {  System.err.println("Error: " + e.getMessage());
      }
    }
}
