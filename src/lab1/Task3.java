package lab1;

public class Task3 {
    public void task3(String[] args) {
        System.out.println("Аргументы:");

        if (args.length == 0) {
            System.out.println("Аргументов нет");
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + i + ": " + args[i]);
        }
    }
}
