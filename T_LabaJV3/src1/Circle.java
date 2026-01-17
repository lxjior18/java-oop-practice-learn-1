public class Circle {

    protected double R;

    public Circle(double R){
        this.R = R;
    }

    public double getArea(){
        return Math.PI * R * R;
    }

    public double getLenght(){
        return 2 * Math.PI * R;
    }

    public void printInfo(){
        System.out.printf("Окружность: R = %.1f%n", R);
        System.out.printf("Площадь = %.1f%n", getArea());
        System.out.printf("Длина = %.1f%n", getLenght());
        System.out.println();
    }

}
