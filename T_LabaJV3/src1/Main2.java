import java.util.Random;   // Класс для генерации случайных чисел
import java.util.Scanner;  // Класс для ввода данных с клавиатуры

// Главный класс программы
public class Main2 {

    // Точка входа в программу
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Объект Scanner для ввода
        Random random = new Random();           // Генератор случайных чисел

        System.out.println("Выберите способ ввода данных:");
        System.out.println("1 - случайные данные");
        System.out.println("2 - ввод с клавиатуры");

        byte choice;

        while (true) {
            choice = scan.nextByte(); // Считывание выбора пользователя

            if (choice == 1 || choice == 2) {
                break;
            } else {
            System.out.println("Ошибка: неверный выбор. Введите 1 или 2.");
            }
        }
        
        int N = readPositiveInt(scan, "Введите количество окружностей N: "); // Количество окружностей
        int M = readPositiveInt(scan, "Введите количество цилиндров M: ");   // Количество цилиндров

        Circle[] circles = new Circle[N];       // Массив окружностей
        Cylinder[] cylinders = new Cylinder[M]; // Массив цилиндров

        switch (choice) {
            case 1:
                for (int i = 0; i < N; i++) {
                    double R = 1 + random.nextDouble() * 9; // Случайный радиус
                    circles[i] = new Circle(R);              // Создание окружности
                }

                for (int i = 0; i < M; i++) {
                    double R = 1 + random.nextDouble() * 9; // Случайный радиус
                    double h = 1 + random.nextDouble() * 9; // Случайная высота
                    cylinders[i] = new Cylinder(R, h);      // Создание цилиндра
                }
                break;

            case 2:
                for (int i = 0; i < N; i++) {
                    double R = readPositiveDouble(
                            scan, "Введите радиус окружности " + (i + 1) + ": "
                    ); // Ввод радиуса окружности
                    circles[i] = new Circle(R); // Создание окружности
                }

                for (int i = 0; i < M; i++) {
                    double R = readPositiveDouble(
                            scan, "Введите радиус цилиндра " + (i + 1) + ": "
                    ); // Ввод радиуса цилиндра
                    double h = readPositiveDouble(
                            scan, "Введите высоту цилиндра " + (i + 1) + ": "
                    ); // Ввод высоты цилиндра
                    cylinders[i] = new Cylinder(R, h); // Создание цилиндра
                }
                break;

            default:
                System.out.println("Неверный выбор."); // Сообщение об ошибке
                scan.close();
                return;
        }

        System.out.println("\nОкружности:");
        for (Circle c : circles) {
            c.printInfo(); // Вывод информации об окружности
        }

        System.out.println("\nЦилиндры:");
        for (Cylinder c : cylinders) {
            c.printInfo(); // Вывод информации о цилиндре
        }

        Circle maxCircle = circles[0]; // Окружность с максимальной площадью
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].getArea() > maxCircle.getArea()) {
                maxCircle = circles[i]; // Обновление максимума
            }
        }

        System.out.println("\nОкружность с максимальной площадью:");
        maxCircle.printInfo(); // Вывод результата

        double sum = 0; // Сумма объемов цилиндров
        for (Cylinder c : cylinders) {
            sum += c.getVolume(); // Суммирование объемов
        }

        double avgVolume = sum / M; // Средний объем цилиндров
        System.out.printf("\nСредний объем цилиндров: %.1f", avgVolume);

        scan.close(); // Закрытие Scanner
    }

    // Считывает положительное целое число
    private static int readPositiveInt(Scanner scan, String message) {
        int value;
        while (true) {
            System.out.print(message);

            if (!scan.hasNextInt()) {
                System.out.println("Ошибка: введите целое число.");
                scan.next();
                continue;
            }

            value = scan.nextInt();

            if (value <= 0) {
                System.out.println("Ошибка: число должно быть больше 0.");
                continue;
            }

            return value; // Возврат корректного значения
        }
    }

    // Считывает положительное вещественное число
    private static double readPositiveDouble(Scanner scan, String message) {
        double value;
        while (true) {
            System.out.print(message);

            if (!scan.hasNextDouble()) {
                System.out.println("Ошибка: введите число.");
                scan.next();
                continue;
            }

            value = scan.nextDouble();

            if (value <= 0) {
                System.out.println("Ошибка: значение должно быть больше 0.");
                continue;
            }

            return value; // Возврат корректного значения
        }
    }
}