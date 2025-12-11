import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[100000];
        Random r = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(1000000);
        }

        StopWatch sw = new StopWatch();
        sw.start();

        SelectionSort.sort(nums);

        sw.stop();
        System.out.println("Время сортировки: " + sw.getElapsedTime() + " мс");
    }
}