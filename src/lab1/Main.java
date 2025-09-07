package lab1;

class Main {
    public static void main(String[] args){
        System.out.println("Первое задание:");
        Task1 task1 = new Task1();
        task1.arraySum();

        System.out.println("-------------------------------------------------------");

        System.out.println("Второе задание:");
        Task2 task2 = new Task2();
        task2.setArraySize();

        System.out.println("-------------------------------------------------------");


        System.out.println("Третье задание:");
        Task3 task3 = new Task3();
        task3.task3(args);

        System.out.println("-------------------------------------------------------");

        System.out.println("Четвертое задание:");
        Task4 task4 = new Task4();
        task4.task4();

        System.out.println("-------------------------------------------------------");

        System.out.println("Пятое задание:");
        Task5 task5 = new Task5();
        task5.task5();
    }
}