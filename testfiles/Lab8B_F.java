/**
 * Write a description of class PhoneBookClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhoneBookEntry
{
  //to hold individuals name
   private final String FULLNAME;
   
  //to hold persons phone number
   private final int NUMBER;

   
   
      public PhoneBookEntry(String name, int digits)
      {
      FULLNAME = name;
      NUMBER   = digits; 
      }
      
             /** 
              * This method is returning the full name
              * @return name
              */
             public String getName()
             {
              return FULLNAME;
             }
             
              /** 
              * This method is returning the individuals phone number
              * @return number
              */
             public int getNumber()
             {
              return NUMBER;
             }




}

