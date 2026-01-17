import java.util.Scanner;

public class Circle {

    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    
    public Circle(Scanner scanner, double r){

        System.out.println("Введите координату x: ");
        this.x = scanner.nextDouble();

        System.out.println("Введите координату y: ");
        this.y = scanner.nextDouble();

        this.r = r;
    } 
    
    public double getLength () {
        return 2 * Math.PI * r;
    }

    public double distanceTo(Circle other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public void printInfo() {
        System.out.printf("Центр (%.0f | %.0f), R = %.1f, длина = %.1f%n", x, y, r, getLength());
    }
}