public class Triangle {

    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean exists() {
        return a > 0 && b > 0 && c > 0 &&
               a + b > c && a + c > b && b + c > a;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void printAngles() {
        double alpha = Math.acos((b*b + c*c - a*a) / (2*b*c));
        double beta  = Math.acos((a*a + c*c - b*b) / (2*a*c));
        double gamma = Math.PI - alpha - beta;

        System.out.printf(
            "Углы: %.1f°, %.1f°, %.1f°%n",
            Math.toDegrees(alpha),
            Math.toDegrees(beta),
            Math.toDegrees(gamma)
        );
    }

    public void printInfo() {
        if (!exists()) {
            System.out.println("Треугольник не существует");
            return;
        }

        System.out.printf(
            "Стороны: %.1f %.1f %.1f, периметр = %.1f, площадь = %.1f%n",
            a, b, c, getPerimeter(), getArea()
        );
        printAngles();
    }
}