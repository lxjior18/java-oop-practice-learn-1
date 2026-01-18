import java.util.Scanner; // Класс для ввода данных с клавиатуры

// Главный класс программы
public class Main {

    // Точка входа в программу
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Объект Scanner для ввода данных

        Circle c1 = new Circle(scanner, 5); // Создание первой окружности
        Circle c2 = new Circle(scanner, 7); // Создание второй окружности

        c1.printInfo(); // Вывод информации о первой окружности
        c2.printInfo(); // Вывод информации о второй окружности

        System.out.printf(
                "Растояние между центрами: %.1f%n",
                c1.distanceTo(c2)
        ); // Вывод расстояния между центрами окружностей

        scanner.close(); // Закрытие Scanner
    }
}