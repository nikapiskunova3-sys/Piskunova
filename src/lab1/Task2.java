package lab1;

import java.util.Scanner;

public class Task2 {
    Scanner scanner = new Scanner(System.in);
    int arraySize = 0;
    int sum = 0;
    int [] array;
    int counter = 0;

    public void setArraySize() {
        System.out.println("Введите размер массива:");
        arraySize = scanner.nextInt();
        array = new int[arraySize];

        setArray();

        findElems();
    }

    public void setArray() {
        while (counter != arraySize) {
            System.out.println("Введите " + counter + " элемент:");
            array[counter] = scanner.nextInt();
            counter += 1;
        }
    }

    public void findElems() {
        int minElem = array[0];
        int maxElem = array[0];

        for (int numbers : array) {
            sum += numbers;

            if (minElem > numbers) {minElem = numbers;}
            if (maxElem < numbers) {maxElem = numbers;}
        }

        System.out.println("Сумма элементов: " + sum);
        System.out.println("Минимальный элемент: " + minElem);
        System.out.println("Максимальный элемент: " + maxElem);
    }
}
