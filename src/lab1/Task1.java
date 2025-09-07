package lab1;


public class Task1 {
    int [] array = {1, 10, 123, -1, 234, 34, 45, 656};

    int avarage = 0;

    int arrayLength = array.length;

    int sum = 0;

    public void arraySum(){
        for (int numbers : array) {
            sum += numbers;
        }

        System.out.println("Сумма массива:" + sum);
        System.out.println("Среднее арифметическое:" + sum/arrayLength);
    }
}
