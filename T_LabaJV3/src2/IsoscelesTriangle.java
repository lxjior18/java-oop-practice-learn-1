public class IsoscelesTriangle extends Triangle {

    public IsoscelesTriangle(double a, double b, double c) {
        super(a, b, c);
    }

    public boolean isIsosceles() {
        return exists() && (a == b || a == c || b == c);
    }

    @Override
    public void printInfo() {
        if (!isIsosceles()) {
            System.out.println("Не равнобедренный треугольник");
            return;
        }
        System.out.print("Равнобедренный ");
        super.printInfo();
    }
}