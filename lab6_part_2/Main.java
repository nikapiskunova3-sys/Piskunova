package lab6_part_2;

public class Main {
    public static void main(String[] args) {

        IStringProcessor processor = new ProcessStrings();
        String s = "abcdef";

        System.out.println("Количество: " + processor.countChars(s));
        System.out.println("Нечетные позиции: " + processor.oddPositions(s));
        System.out.println("Перевернутое: " + processor.invert(s));

        Printable[] arr = {
                new Magazine("National Geographic"),
                new Book("War and Peace"),
                new Magazine("Time"),
                new Book("1984")
        };

        System.out.println("\nТолько журналы:");
        Magazine.printMagazines(arr);
    }
}
