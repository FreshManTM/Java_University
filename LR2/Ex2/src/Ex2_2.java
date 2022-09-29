import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_2 {
    public static void Enter(byte[] massive, Scanner sc){
        for(int i = 0; i < massive.length; i++) {
            System.out.print("Enter  " + (i + 1) + " number:");
            massive[i] = sc.nextByte();
        }
    }
    public static byte Sum(byte[] massive){
        byte summa = 0;     // sum of the entered numbers
        for(int i = 0; i < massive.length; i++) {
            summa += massive[i];
        }
        return summa;
    }

    public static void main(String[] arghs) {
        int amount;     //amount of the entered number
        byte massive[]; //massive of the numbers

        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Enter amount of numbers:");
        amount = sc.nextInt();

        massive = new byte[amount];

        try {
            Enter(massive,sc);
            System.out.println("Sum of the all the entered numbers: " + Sum(massive));
        }
        catch (InputMismatchException e){
            System.out.println("You have entered wrong value! Please enter the byte number.");
        }
    }
}