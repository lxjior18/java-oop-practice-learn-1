// Класс Cylinder, наследующий класс Circle
public class Cylinder extends Circle {

    private double h; // Высота цилиндра

    // Конструктор класса Cylinder
    public Cylinder(double R, double h) {
        super(R);     // Инициализация радиуса через конструктор родительского класса
        this.h = h;   // Инициализация высоты
    }

    // Вычисляет объём цилиндра
    public double getVolume() {
        return getArea() * h; // Формула объёма цилиндра
    }

    // Вычисляет площадь полной поверхности цилиндра
    @Override
    public double getArea() {
        return 2 * Math.PI * R * R + 2 * Math.PI * R * h; // Площадь оснований и боковой поверхности
    }

    // Выводит информацию о цилиндре
    @Override
    public void printInfo() {
        System.out.printf("Цилиндр: R = %.1f%n", R);                 // Вывод радиуса
        System.out.printf("h = %.1f%n", h);                          // Вывод высоты
        System.out.printf("Площадь поверхности = %.1f%n", getArea()); // Вывод площади поверхности
        System.out.printf("Объем = %.1f%n", getVolume());             // Вывод объёма
        System.out.println();
    }
}