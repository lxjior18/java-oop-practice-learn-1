// Главный класс программы
public class Main {

    // Точка входа в программу
    public static void main(String[] args) {

        Circle c1 = new Circle(0, 0, 5); // Создание первой окружности
        Circle c2 = new Circle(3, 4, 2); // Создание второй окружности

        c1.printInfo(); // Вывод информации о первой окружности
        c2.printInfo(); // Вывод информации о второй окружности

        System.out.printf(
                "Растояние между центрами: %.1f%n",
                c1.distanceTo(c2)
        ); // Вывод расстояния между центрами окружностей
    }
}