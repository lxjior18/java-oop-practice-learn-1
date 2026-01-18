import java.util.Random;   // Класс для генерации случайных чисел
import java.util.Scanner;  // Класс для ввода данных с клавиатуры

// Главный класс программы
public class Main3 {

    // Точка входа в программу
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // Объект Scanner для ввода
        Random random = new Random();           // Генератор случайных чисел

        System.out.println(
            "Выберите способ задания треугольников:\n" +
            "1 - случайные значения\n" +
            "2 - ввод с клавиатуры"
        ); // Вывод меню выбора

        byte choice; // Переменная для хранения выбора пользователя

        // Проверка корректности выбора способа ввода
        while (true) {
            choice = scan.nextByte(); // Считывание выбора

            if (choice == 1 || choice == 2) {
                break; // Корректный выбор
            } else {
                System.out.println("Ошибка: неверный выбор. Введите 1 или 2.");
            }
        }

        int N = readPositiveInt(scan, "Введите количество треугольников N: "); // Количество треугольников
        int M = readPositiveInt(scan, "Введите количество равнобедренных M: "); // Количество равнобедренных

        Triangle[] triangles = new Triangle[N];                 // Массив треугольников
        IsoscelesTriangle[] isoTriangles = new IsoscelesTriangle[M]; // Массив равнобедренных треугольников

        switch (choice) {

            case 1:
                // Формирование треугольников со случайными сторонами
                for (int i = 0; i < N; i++) {
                    Triangle t;
                    do {
                        double a = 2 + random.nextDouble() * 8; // Случайная сторона a
                        double b = 2 + random.nextDouble() * 8; // Случайная сторона b
                        double c = 2 + random.nextDouble() * 8; // Случайная сторона c
                        t = new Triangle(a, b, c);              // Создание треугольника
                    } while (!t.exists());                       // Проверка существования

                    triangles[i] = t;                            // Сохранение треугольника
                }

                // Формирование равнобедренных треугольников со случайными сторонами
                for (int i = 0; i < M; i++) {
                    IsoscelesTriangle t;
                    do {
                        double a = 2 + random.nextDouble() * 8; // Равные стороны
                        double c = 2 + random.nextDouble() * 8; // Основание
                        t = new IsoscelesTriangle(a, a, c);     // Создание равнобедренного треугольника
                    } while (!t.exists());                       // Проверка существования

                    isoTriangles[i] = t;                         // Сохранение треугольника
                }
                break;

            case 2:
                // Ввод треугольников с клавиатуры
                for (int i = 0; i < N; i++) {
                    System.out.println("\nТреугольник " + (i + 1)); // Номер треугольника

                    while (true) {
                        double a = readPositiveDouble(scan, "Введите сторону a: "); // Ввод стороны a
                        double b = readPositiveDouble(scan, "Введите сторону b: "); // Ввод стороны b
                        double c = readPositiveDouble(scan, "Введите сторону c: "); // Ввод стороны c

                        Triangle t = new Triangle(a, b, c); // Создание треугольника
                        if (t.exists()) {
                            triangles[i] = t;              // Сохранение корректного треугольника
                            break;
                        } else {
                            System.out.println("Такой треугольник не существует. Повторите ввод.");
                        }
                    }
                }

                // Ввод равнобедренных треугольников с клавиатуры
                for (int i = 0; i < M; i++) {
                    System.out.println("\nРавнобедренный треугольник " + (i + 1));

                    while (true) {
                        double a = readPositiveDouble(
                                scan, "Введите равные стороны a и b: "
                        ); // Ввод равных сторон
                        double c = readPositiveDouble(
                                scan, "Введите основание c: "
                        ); // Ввод основания

                        IsoscelesTriangle t = new IsoscelesTriangle(a, a, c); // Создание треугольника
                        if (t.exists()) {
                            isoTriangles[i] = t; // Сохранение корректного треугольника
                            break;
                        } else {
                            System.out.println("Ошибка: такой треугольник не существует.");
                        }
                    }
                }
                break;

            default:
                System.out.println("Неверный выбор.");
                scan.close();
                return;
        }

        System.out.println("\nТреугольники:");
        double sumArea = 0; // Суммарная площадь треугольников

        // Вывод информации о треугольниках и подсчёт площади
        for (Triangle t : triangles) {
            t.printInfo();          // Вывод информации
            sumArea += t.getArea(); // Суммирование площадей
            System.out.println();
        }

        if (N > 0) {
            double avgArea = sumArea / N; // Средняя площадь
            System.out.printf("Средняя площадь треугольников: %.1f%n", avgArea);
        }

        // Поиск равнобедренного треугольника с минимальной площадью
        if (M > 0) {
            IsoscelesTriangle min = isoTriangles[0]; // Начальное минимальное значение
            for (int i = 1; i < isoTriangles.length; i++) {
                if (isoTriangles[i].getArea() < min.getArea()) {
                    min = isoTriangles[i];           // Обновление минимума
                }
            }

            System.out.println("\nРавнобедренный треугольник с минимальной площадью:");
            min.printInfo(); // Вывод результата
        } else {
            System.out.println("\nРавнобедренные треугольники отсутствуют.");
        }

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
                System.out.println("Ошибка: число должно быть больше 0.");
                continue;
            }

            return value; // Возврат корректного значения
        }
    }
}