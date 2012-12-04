//Obaid Omid
//Assignment8b
import java.util.*;
public class PhoneBookEntry //class
{

  private String rookery;
  private String spy;
  //Constructor
  public PhoneBookEntry(String aName, String aNumber){ 
      rookery = aName;
      spy = aNumber;
  }
  //Accessor
  public String getName(){
    return rookery;
  }
  //Accessor
  public String getNumber(){
  return spy;
  }
  public String toString(){
    return "Name: " + getName() + "________Number: " + getNumber();
  }
  //Mutator
  public void setName(String n){
      rookery = n;
  }
  //Mutator
  public void setNumber(String num){
      spy = num;
  } 
}

