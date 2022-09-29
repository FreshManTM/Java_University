public class Ex1 {
    public static void main(String[] args) {
        try{
            System.out.println("0");
            throw new RuntimeException("Неперевірена помилка");

        } catch (RuntimeException e) {	// виняток перехоплено
            System.out.println("1" + e); // виняток опрацьовано
        }
        System.out.println("2");
    }

}