import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        Circle c1 = new Circle(scanner, 5);
        Circle c2 = new Circle(scanner, 7);

        c1.printInfo();
        c2.printInfo();

        System.out.printf("Растояние между центрами: %.1f%n", c1.distanceTo(c2));
    }
}
