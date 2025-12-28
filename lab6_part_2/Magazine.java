package lab6_part_2;

public class Magazine implements Printable {

    private String name;

    public Magazine(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Magazine: " + name);
    }

    public String getName() {
        return name;
    }

    public static void printMagazines(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Magazine) {
                System.out.println(((Magazine) p).getName());
            }
        }
    }
}