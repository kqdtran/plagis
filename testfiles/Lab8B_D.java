/**
 * Write a description of class P2PhoneBookEntry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhoneBookEntry
{
    // instance variables - replace the example below with your own
    private int phoneNumber;
    private String name;
    

    /**
     * Constructor for objects of class P2PhoneBookEntry
     */
    public PhoneBookEntry(String str,int num)
    {
        // initialise instance variables
        phoneNumber = num;
        name = str;
    }

    public void setName(String aName)
    {
        name = aName;
        
    }
    public void setPhone(int aNumber)
    {
        phoneNumber = aNumber;
    }
    public int getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getName()
    {
        return name;
    }
    
}

