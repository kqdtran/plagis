import java.util.ArrayList;
/**
 * Contains constructor, accessor, and mutator methods to create phone book entries.
 * 
 * @author (Andrew Harasta) 
 * @version (April 17th, 2012)
 */
public class P2PhoneBookEntry
{   String name;
    String number;
    
   public P2PhoneBookEntry(String phoneName, String phoneNumber)
   {
       
       name = phoneName;
       number = phoneNumber;
    
   }
   public void setName(String phoneName)
   {
      name = phoneName;    
   }
   public String getName()
   {
        return name;   
   }
   public void setNumber(String phoneNumber)
   {
     number = phoneNumber;     
   }
   public String getNumber()
   { 
       return number;
   }
} 