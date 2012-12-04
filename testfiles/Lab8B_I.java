import java.util.Scanner;
/**
 * Write a description of class P2PhoneBookEntry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P2PhoneBookEntry
{
    private String name;
    private int number;
    private Scanner input = new Scanner(System.in);
    
    public P2PhoneBookEntry (int indexNum)
    {
        System.out.println ("Enter the name of person: " + (indexNum + 1));
        name = input.nextLine();
        System.out.println ("Enter the number of person: " +(indexNum + 1));
        number = input.nextInt();

        input.nextLine();
    }

    public String getList ()
    {
        String list;
        list = ("NAME: " + name + "\nPHONE: " + number);
        return list;
    }
}

