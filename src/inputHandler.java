import java.util.Scanner;

public  class inputHandler {
public static double getInput(Scanner scannerObject,String message)
{
    System.out.println(message);
    if(!scannerObject.hasNextLong())
    {
        System.out.println("Enter valid input(only numbers are allowed)");
        System.exit(1);
    }

        return scannerObject.nextDouble();

}
}
