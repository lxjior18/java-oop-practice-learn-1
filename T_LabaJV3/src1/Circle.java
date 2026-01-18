// Класс Circle, описывающий окружность
public class Circle {

    protected double R; // Радиус окружности

    // Конструктор класса Circle
    public Circle(double R) {
        this.R = R; // Инициализация радиуса
    }

    // Вычисляет площадь окружности
    public double getArea() {
        return Math.PI * R * R; // Формула площади
    }

    // Вычисляет длину окружности
    public double getLenght() {
        return 2 * Math.PI * R; // Формула длины окружности
    }

    // Выводит информацию об окружности
    public void printInfo() {
        System.out.printf("Окружность: R = %.1f%n", R);        // Вывод радиуса
        System.out.printf("Площадь = %.1f%n", getArea());     // Вывод площади
        System.out.printf("Длина = %.1f%n", getLenght());     // Вывод длины
        System.out.println();
    }
}