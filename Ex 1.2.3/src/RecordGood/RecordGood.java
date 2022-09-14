package RecordGood;

import java.util.Scanner;
class Goods {
    String name;
    String creator;
    int units_number;
    double price;
}

public class RecordGood{
    public static void main(String [] args) {
        Scanner sc = new Scanner (System.in, "cp1251");

// Введення інформації про товари
        System.out.println("Введіть кількість товарів => ");
        int amount=sc.nextInt();
        Goods good[]=new Goods[amount];
        System.out.println("Введіть інформацію про товари: ");
        for(int i = 0; i < good.length; i++) {
            sc.nextLine(); 	//	очищення буфера
            good [i] = new Goods();
            System.out.print("Назва "+(i+1)+"-го товару => ");
            good[i].name=sc.nextLine();
            System.out.print("Виробник "+(i+1)+"-го товару => ");
            good[i].creator=sc.nextLine();
            System.out.print("Кількість одиниць "+(i+1)+"-го товару => ");
            good[i].units_number=sc.nextInt();
            System.out.print("Ціна "+(i+1)+"-го товару => ");
            good[i].price=sc.nextDouble();
        }

// Виведення отриманої інформації
        System.out.println("\nХарактеристики товарів:");
        for(int i = 0; i < good.length; i++) { System.out.println("" + good[i].name + "\t" + good[i].creator + "\t" + good[i].units_number + "\t" + good[i].price + " $");
        }


// Товар з максимальною кількістю одиниць
        int nommax=0;	//номер елемента для країни з максимальною кількістю одиниць (початкове значення)
        double max = good[nommax].units_number; //максимальна кількість одиниць (початкове значення)
        for (int i = 0; i < good.length; i++) if (good[i].units_number>max) {
            max = good [i]. units_number;
            nommax=i;
        }
        System.out.println("\nТовари із максимальною кількістю одиниць :");
        System.out.println("" + good[nommax].name + "\t" + good[nommax].creator + "\t" + good[nommax].units_number + "\t" + good[nommax].price + " $");

// Сортування товару за кількістю одиниць
        for (int i = 0; i < good.length-1; i++)
            for (int j = 0; j < good.length-1-i; j++)
                if (good[j].price < good[j+1].price){
                    Goods rab=good[j];	//rab – робоча змінна для перестановки
                    good [j] = good [j + 1];
                    good [j + 1] = rab;
                }
        System.out.println("\nВідсортований список за спаданням цін товарів:");
        for (int i = 0; i < good.length; i++) {
            System.out.println("" + good[i].name + "\t" + good[i].creator + "\t" + good[i].units_number + "\t" + good[i].price + " $");
        }

// Ціна менша середньої
        double s=0;	//сумарна ціна
        for (int i = 0; i < good.length; i++)
            s+=good[i].price;
        double sr=s/good.length; ;	//середня ціна
        System.out.println("Середня ціна ="+sr);
        System.out.println("\nТовари з ціною менше середньої:");
        for (int i = 0; i < good.length; i++) {
            if (good[i].price<sr)
                System.out.println("" + good[i].name + "\t" + good[i].creator + "\t" + good[i].units_number + "\t" + good[i].price + " $");
        }
// Пошук за назвою
        sc.nextLine();			 // очищення буфера
        System.out.println("Введіть назву шуканого товару=>");
        String name=sc.nextLine();
        int nom = -1;
        for (int i = 0; i < good.length; i++)
            if (name.equalsIgnoreCase(good[i].name)) nom=i;

        if (nom != -1) {
            System.out.println("Такий товар є у списку. Це: " + "\n" +"" + good[nom].name + "\t" + good[nom].creator + "\t" + good[nom].units_number + "\t" + good[nom].price + " $.");
            //Редагування товару
            System.out.println("Якщо хочете відредагувати товар напишіть: n - ім'я товару, c - виробника товару, u - кількість одиниць товару, p - ціну товару. Щоб вийти напиціть 'q'");
            System.out.println("=> ");
            String in = sc.nextLine();
            switch (in) {
                case "n": {
                    System.out.println("Введіть нову назву товару:");
                    String newvar = sc.nextLine();
                    good[nom].name = newvar;
                    break;
                }
                case "c": {
                    System.out.println("Введіть нового виробника товару:");
                    String newvar = sc.nextLine();
                    good[nom].creator = newvar;
                    break;
                }
                case "u": {
                    System.out.println("Введіть нову кількість одиниць товару:");
                    int newvar = sc.nextInt();
                    good[nom].units_number = newvar;
                    break;
                }
                case "p": {
                    System.out.println("Введіть нову ціну товару:");
                    Double newvar = sc.nextDouble();
                    good[nom].price = newvar;
                    break;
                }
                case "q": {
                    break;
                }
                default:{
                    System.out.println("Ви ввели не правильні данні!");
                }
            }
            System.out.println("Оновленні дані товару: " + "\n" +"" + good[nom].name + "\t" + good[nom].creator + "\t" + good[nom].units_number + "\t" + good[nom].price + " $.");
        }
        else
            System.out.println("Такого товару немає у списку.");
    }
}
