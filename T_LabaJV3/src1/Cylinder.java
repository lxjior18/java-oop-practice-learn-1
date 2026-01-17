public class Cylinder extends Circle {

    private double h;

    public Cylinder(double R, double h) {
        super(R);
        this.h = h;
    }

    public double getVolume() {
        return getArea() * h;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * R * R + 2 * Math.PI * R * h;
    }

    @Override
    public void printInfo() {
        System.out.printf("Цилиндр: R = %.1f%n", R);
        System.out.printf("h = %.1f%n", h);
        System.out.printf("Площадь поверхности = %.1f%n", getArea());
        System.out.printf("Объем = %.1f%n", getVolume());
        System.out.println();

    }
}    
