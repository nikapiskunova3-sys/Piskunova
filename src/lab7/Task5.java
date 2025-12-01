package lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task5 {

    public static void main(String[] args) {

        int count = 15000;

        List<Integer> aList = new ArrayList<>();
        List<Integer> lList = new LinkedList<>();

        long t1 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            aList.add(i);
        }
        long aAdd = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            lList.add(i);
        }
        long lAdd = System.nanoTime() - t2;

        t1 = System.nanoTime();
        aList.add(1, 1000);
        long aInsert = System.nanoTime() - t1;

        t2 = System.nanoTime();
        lList.add(1, 1000);
        long lInsert = System.nanoTime() - t2;

        t1 = System.nanoTime();
        aList.remove(aList.size() - 2);
        long aRemove = System.nanoTime() - t1;

        t2 = System.nanoTime();
        lList.remove(lList.size() - 2);
        long lRemove = System.nanoTime() - t2;

        t1 = System.nanoTime();
        aList.contains(5000);
        long aSearch = System.nanoTime() - t1;

        t2 = System.nanoTime();
        lList.contains(5000);
        long lSearch = System.nanoTime() - t2;

        System.out.println("Результаты:");
        System.out.println("ArrayList add: " + aAdd);
        System.out.println("LinkedList add: " + lAdd);
        System.out.println("ArrayList insert: " + aInsert);
        System.out.println("LinkedList insert: " + lInsert);
        System.out.println("ArrayList remove: " + aRemove);
        System.out.println("LinkedList remove: " + lRemove);
        System.out.println("ArrayList search: " + aSearch);
        System.out.println("LinkedList search: " + lSearch);
    }
}

