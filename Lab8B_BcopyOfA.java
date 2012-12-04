/**
 * Write a description of class PhoneBookEntry here.
 * 
 * @author Darryl Holman 
 * @version 4/24/12
 */
import java.util.*;
public class PhoneBookEntry
{

  private String name;
  private String number;
  //Constructor
  public PhoneBookEntry(String aName, String aNumber){ 
      name = aName;
      number = aNumber;
  }
  //Accessor method
  public String getName()
  {
    return name;
  }
  //Accessor method
  public String getNumber()
  {
  return number;
  }
  public String toString(){
    return "Name: " + getName() + "________Number: " + getNumber();
  }
  //Mutator method
  public void setName(String n)
  {
      name = n;
  }
  //Mutator method
  public void setNumber(String num)
  {
      number = num;
  } 
}

