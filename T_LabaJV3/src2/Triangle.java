// Класс Triangle, описывающий треугольник
public class Triangle {

    protected double a, b, c; // Длины сторон треугольника

    // Конструктор класса Triangle
    public Triangle(double a, double b, double c) {
        this.a = a; // Инициализация стороны a
        this.b = b; // Инициализация стороны b
        this.c = c; // Инициализация стороны c
    }

    // Проверяет существование треугольника
    public boolean exists() {
        return a > 0 && b > 0 && c > 0 &&        // Проверка положительности сторон
               a + b > c && a + c > b && b + c > a; // Неравенства треугольника
    }

    // Вычисляет периметр треугольника
    public double getPerimeter() {
        return a + b + c; // Сумма длин сторон
    }

    // Вычисляет площадь треугольника по формуле Герона
    public double getArea() {
        double p = getPerimeter() / 2; // Полупериметр
        return Math.sqrt(p * (p - a) * (p - b) * (p - c)); // Формула Герона
    }

    // Вычисляет и выводит значения углов треугольника
    public void printAngles() {
        double alpha = Math.acos((b * b + c * c - a * a) / (2 * b * c)); // Угол при стороне a
        double beta  = Math.acos((a * a + c * c - b * b) / (2 * a * c)); // Угол при стороне b
        double gamma = Math.PI - alpha - beta;                           // Третий угол

        System.out.printf(
            "Углы: %.1f°, %.1f°, %.1f°%n",
            Math.toDegrees(alpha), // Перевод в градусы
            Math.toDegrees(beta),
            Math.toDegrees(gamma)
        );
    }

    // Выводит информацию о треугольнике
    public void printInfo() {
        if (!exists()) {
            System.out.println("Треугольник не существует"); // Проверка корректности
            return;
        }

        System.out.printf(
            "Стороны: %.1f %.1f %.1f, периметр = %.1f, площадь = %.1f%n",
            a, b, c, getPerimeter(), getArea() // Вывод параметров треугольника
        );

        printAngles(); // Вывод углов треугольника
    }
}