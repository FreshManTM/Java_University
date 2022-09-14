package recordGood2;
import java.util.Scanner;

class Goods {
    String name;
    String creator;
    int units_number;
    double price;
}

public class RecordGoods2 {
// МЕТОДИ ДЛЯ ВСІХ ПІДЗАДАЧ для роботи з об'єктами класу Goods

    public static Goods[] setGoodArr(int k) {
// Введення інформації про товари
        Scanner sc = new Scanner(System.in, "cp1251");
        Goods goods[] = new Goods[k];

        System.out.println("Введіть інформацію про товари: ");
        for (int i = 0; i < goods.length; i++) {
            goods[i] = new Goods();
            System.out.print("Назва " + (i + 1) + "-го товару => ");
            goods[i].name = sc.nextLine();
            System.out.print("Виробник " + (i + 1) + "-го товару => ");
            goods[i].creator = sc.nextLine();
            System.out.print("Кількість одиниць " + (i + 1) + "-го товару => ");
            goods[i].units_number = sc.nextInt();
            System.out.print("Ціна " + (i + 1) + "-го товару => ");
            goods[i].price = sc.nextDouble();
            sc.nextLine();   // очищення буфера
        }
        return goods;
    }

    public static void showArray(Goods[] goods) {
// Виведення масиву
        for (int i = 0; i < goods.length; i++) {
            System.out.println("" + goods[i].name + "\t" + goods[i].creator + "\t" + goods[i].units_number + "\t" + goods[i].price + " $");
        }
    }

    public static void showGoods(Goods goods) {
// Інформація про один товар
        System.out.println("" + goods.name + "\t" + goods.creator + "\t" + goods.units_number + "\t" + goods.price + " $");
    }

    public static int NomMax(Goods[] goods) {
// Номер товару з максимальною кількістю одиниць
        int nommax = 0;    //номер елемента для товару з максимальною кількістю одиниць (початкове значення)
        double max = goods[nommax].units_number; //максимальна кількість одиниць (початкове значення)
        for (int i = 0; i < goods.length; i++)
            if (goods[i].units_number > max) {
                max = goods[i].units_number;
                nommax = i;
            }
        return nommax;
    }

    public static void sortUnitsNumber(Goods[] goods) {
// Сортування товару за кількістю одиниць
        for (int i = 0; i < goods.length - 1; i++)
            for (int j = 0; j < goods.length - 1 - i; j++)
                if (goods[j].price < goods[j + 1].price) {
                    Goods rab = goods[j];    //rab – робоча змінна для перестановки
                    goods[j] = goods[j + 1];
                    goods[j + 1] = rab;
                }
    }

    public static double avgPrice(Goods[] goods) {
// Середня ціна
        double s = 0;    //сумарна ціна
        for (int i = 0; i < goods.length; i++)
            s += goods[i].price;
        double sr = s / goods.length;
        ;    //середня ціна
        return sr;
    }

    public static Goods[] lowerPrice(Goods goods[]) {
// Товари з ціною менше середньої
        double sred = avgPrice(goods);
        int kol = 0;    //кількість товарів
        for (int i = 0; i < goods.length; i++) {
            if (goods[i].price < sred)
                ++kol;
        }

        if (kol != 0) {
            Goods[] bigGoods = new Goods[kol];
            int n = -1;
            for (int i = 0; i < goods.length; i++)
                if (goods[i].price < sred) {
                    bigGoods[++n] = goods[i];
                }
            return bigGoods;
        } else return null;
    }

    public static Goods findForName(Goods goods[], String name) {
// Пошук за назвою
        int n = -1;            //-1 – товар з шуканою назвою відсутній
        for (int i = 0; i < goods.length; i++)
            if (name.equals(goods[i].name))
                n = i;
        if (n != -1)
            return goods[n];
        else
            return null;
    }

    public static void editGoods(String name,Goods goods[], Scanner sc) {
        //редагувати товар
        int nom = -1;
        for (int i = 0; i < goods.length; i++)
            if (name.equalsIgnoreCase(goods[i].name)) nom = i;

        if (nom != -1) {
            System.out.println("Якщо хочете відредагувати товар напишіть: n - ім'я товару, c - виробника товару, u - кількість одиниць товару, p - ціну товару. Щоб вийти напиціть 'q'");
            System.out.println("=> ");
            String in = sc.nextLine();
            switch (in) {
                case "n": {
                    System.out.println("Введіть нову назву товару:");
                    String newvar = sc.nextLine();
                    goods[nom].name = newvar;
                    break;
                }
                case "c": {
                    System.out.println("Введіть нового виробника товару:");
                    String newvar = sc.nextLine();
                    goods[nom].creator = newvar;
                    break;
                }
                case "u": {
                    System.out.println("Введіть нову кількість одиниць товару:");
                    int newvar = sc.nextInt();
                    goods[nom].units_number = newvar;
                    break;
                }
                case "p": {
                    System.out.println("Введіть нову ціну товару:");
                    Double newvar = sc.nextDouble();
                    goods[nom].price = newvar;
                    break;
                }
                case "q": {
                    break;
                }
                default:{
                    System.out.println("Ви ввели не правильні данні! Будь ласка спробуйте ще раз:");
                    editGoods(name, goods, sc);

                }
            }
            System.out.println("Оновленні дані товару: " + "\n" +"" + goods[nom].name + "\t" + goods[nom].creator + "\t" + goods[nom].units_number + "\t" + goods[nom].price + " $.");
        }
    }
        public static void main (String[]args){
// ГОЛОВНИЙ КЛАС З МЕТОДАМИ
            Scanner sc = new Scanner(System.in, "cp1251");
            System.out.println("Введіть кількість товарів => ");
            int n = sc.nextInt();    // кількість країн
            Goods goods[] = setGoodArr(n);    // Введення інформації про країни

            System.out.println("\nХарактеристики товарів:");
            System.out.println(" \n" + "Name" + "\t Creator" + "\t Units number" + "\t Price");
            showArray(goods);            // Виведення отриманої інформації

// Товари із максимальною кількістю одиниць
            int nommax = NomMax(goods);
            System.out.println("\nТовари із максимальною кількістю одиниць :");
            System.out.println(" \n" + "Name" + "\t Creator" + "\t Units number" + "\t Price");

            showGoods(goods[nommax]);

// Сортування товару за кількістю одиниць
            sortUnitsNumber(goods);
            System.out.println("\nВідсортований список за спаданням цін товарів:");
            showArray(goods);

// Середня ціна
            System.out.println("Середня ціна =" + avgPrice(goods));

// Ціна менша середньої
            System.out.println("\nТовари з ціною менше середньої:");
            if(n != 1){
                Goods[] larger = lowerPrice(goods);
                showArray(larger);
            }
            else {
                System.out.println("Немає");
            }


// Пошук за назвою
            System.out.println("\nПошук товару \n Введіть назву шуканого товару=> ");
            sc.nextLine();
            String sname = sc.nextLine();
            Goods sfind = findForName(goods, sname);
            if (sfind != null) {
                showGoods(sfind);
                editGoods(sname,goods, sc);
            } else {
                System.out.println("Такого товару немає у списку!");
            }
        }
    }