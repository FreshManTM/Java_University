import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_1 {
    public static void main(String[] arghs) {

        int amount;
        byte massive[];
        byte summa = 0;

        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.print("Enter amount of numbers:");
        amount = sc.nextInt();

        massive = new byte[amount];
        for(int i = 0; i < massive.length; i++) {
            System.out.print("Enter  " + (i + 1) + " number:");
            try {
                byte n = sc.nextByte();
                massive[i] = n;
            }
            catch (InputMismatchException e){
                System.out.println("You have entered wrong value! Please enter the byte number.");
                break;
            }
        }
        for(int i = 0; i < massive.length; i++){
            try {
                summa += massive[i];
            }
            catch (InputMismatchException e) {
                System.out.println("The sum of the numbers is out of the range.");
                break;
            }
        }

        System.out.println("Sum of the all the entered numbers: " + summa);
    }
}