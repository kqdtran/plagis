/**
 * The PhoneBookEntry class stores names and phone numbers of diffrent individuals
 */
public class PhoneBookEntry
{
    private String name;
    private String number;
    
    /**
     * Constructor
     * @param theName Hold's the name of an individual
     * @param teleNum Hold's the number of an individual
     */
    public PhoneBookEntry(String theName, String telNum)
    {
        this.name = theName;
        this.number = telNum;
    }
    
    
    /**
     * The setName method sets the name of the individual in the phonebook
     * @param theName Holds the name of the individual
     */
    public void setName( String theName)
    {
        name = theName;
    }
    
    /**
     * The setNumber method sets the number of the individual in the phonebook
     * @param telNum Holds the number of an individual
     */
    public void setNumber(String telNum)
    {
        number = telNum;
    }
    
    /**
     * The getName method returns the name or an individual 
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * The getNumber method returns the number of an individual
     * @return number
     */
    public String getNumber()
    {
        return number;
    }
}
