import java.util.Scanner;
class Hashtableop
{
    private int currentSize, maxSize;       
    private String[] keys;   
    private String[] vals;    
 
    public Hashtableop(int capacity) 
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }  
 
   
    private int hash(String key) 
    {
        return key.hashCode() % maxSize;
    }    
 
    public void insert(String key, String val) 
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
            return;
 
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
 

public class Hashtable
{
    public static void main(String[] args)
    {
        import java.util.Scanner;
class Hashtableop
{
    private int currentSize, maxSize;       
    private String[] keys;   
    private String[] vals;    
 
    public Hashtableop(int capacity) 
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }  
 
   
    private int hash(String key) 
    {
        return key.hashCode() % maxSize;
    }    
 
    public void insert(String key, String val) 
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
            return;
 
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
    }
}   
 
    
   