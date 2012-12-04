//Obaid Omid
//Assignment8b
import java.util.*;
public class PhoneBookEntry //class
{

  private String name;
  private String number;
  //Constructor
  public PhoneBookEntry(String aName, String aNumber){ 
      name = aName;
      number = aNumber;
  }
  //Accessor
  public String getName(){
    return name;
  }
  //Accessor
  public String getNumber(){
  return number;
  }
  public String toString(){
    return "Name: " + getName() + "________Number: " + getNumber();
  }
  //Mutator
  public void setName(String n){
      name = n;
  }
  //Mutator
  public void setNumber(String num){
      number = num;
  } 
}

