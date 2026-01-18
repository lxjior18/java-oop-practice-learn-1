import java.util.Random;   // Класс для генерации случайных чисел
import java.util.Scanner;  // Класс для ввода данных с клавиатуры

public class Laba1 {

    // Главный метод программы
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Создание объекта Scanner

        System.out.println("Выберите задание:"); // Вывод меню
        System.out.println("1 - Тип треугольника");
        System.out.println("2 - НОД двух чисел");
        System.out.println("3 - Последовательность sin");
        System.out.println("4 - Числа Фибоначчи");
        System.out.println("5 - Простые делители числа");

        byte choice = scan.nextByte(); // Считывание номера задания

        switch (choice) { // Выбор выполняемого задания
            case 1:
                triangleTask(scan); // Вызов задания 1
                break;
            case 2:
                gcdTask(scan); // Вызов задания 2
                break;
            case 3:
                sinTask(scan); // Вызов задания 3
                break;
            case 4:
                fibonacciTask(scan); // Вызов задания 4
                break;
            case 5:
                primeDivisorsTask(scan); // Вызов задания 5
                break;
            default:
                System.out.println("Неверный выбор"); // Сообщение об ошибке
        }

        scan.close(); // Закрытие Scanner
    }

    // Определение типа треугольника
    private static void triangleTask(Scanner scan) {
        int a, b, c; // Переменные для сторон треугольника

        System.out.println(
                "Выбор решения задачи:\n" +
                "1 - случайные стороны\n" +
                "2 - произвольные стороны"
        );

        byte choice1 = scan.nextByte(); // Считывание способа задания сторон

        switch (choice1) {
            case 1:
                Random random = new Random(); // Создание генератора случайных чисел
                a = random.nextInt(201) - 100; // Генерация стороны a
                b = random.nextInt(201) - 100; // Генерация стороны b
                c = random.nextInt(201) - 100; // Генерация стороны c

                System.out.println("a = " + a); // Вывод стороны a
                System.out.println("b = " + b); // Вывод стороны b
                System.out.println("c = " + c); // Вывод стороны c
                break;

            case 2:
                a = readPositiveNumber(scan, "Введите сторону a: "); // Ввод стороны a
                b = readPositiveNumber(scan, "Введите сторону b: "); // Ввод стороны b
                c = readPositiveNumber(scan, "Введите сторону c: "); // Ввод стороны c
                break;

            default:
                System.out.println("Неверный выбор"); // Обработка ошибки
                return;
        }

        isTriangle(a, b, c); // Проверка существования и типа треугольника
    }

    // Проверка возможности построения треугольника
    private static void isTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0 ||      // Проверка положительности сторон
            a + b <= c || a + c <= b ||        // Проверка неравенств треугольника
            b + c <= a) {
            System.out.println("0 - треугольник невозможен");
        } else if (a == b && b == c) {          // Проверка равенства всех сторон
            System.out.println("3 - равносторонний");
        } else if (a == b || a == c || b == c) {// Проверка равенства двух сторон
            System.out.println("2 - равнобедренный");
        } else {
            System.out.println("1 - разносторонний"); // Все стороны разные
        }
    }

    // Нахождение наибольшего общего делителя
    private static void gcdTask(Scanner scan) {
        int a, b; // Переменные для чисел

        System.out.println(
                "Выбор решения задачи:\n" +
                "1 - рандомные числа\n" +
                "2 - произвольные числа"
        );

        byte choice2 = scan.nextByte(); // Считывание выбора пользователя

        switch (choice2) {
            case 1:
                Random random = new Random(); // Создание генератора случайных чисел
                a = random.nextInt();         // Генерация числа a
                b = random.nextInt();         // Генерация числа b

                if (a <= 0 || b <= 0) {        // Проверка на натуральность
                    System.out.println("Ошибка: одно из чисел не натуральное");
                    return;
                }

                System.out.println("a = " + a); // Вывод числа a
                System.out.println("b = " + b); // Вывод числа b
                break;

            case 2:
                a = readPositiveNumber(scan, "Введите a: "); // Ввод числа a
                b = readPositiveNumber(scan, "Введите b: "); // Ввод числа b
                break;

            default:
                System.out.println("Неверный выбор"); // Сообщение об ошибке
                return;
        }

        int c = gcd(a, b); // Вызов алгоритма Евклида
        System.out.println("НОД = " + c); // Вывод результата
    }

    // Алгоритм Евклида для нахождения НОД
    private static int gcd(int a, int b) {
        while (b != 0) {      // Пока второе число не равно нулю
            int r = a % b;    // Остаток от деления
            a = b;            // Присваивание нового значения a
            b = r;            // Присваивание нового значения b
        }
        return a;             // Возврат НОД
    }

    // Вычисление последовательности sin
    private static void sinTask(Scanner scan) {
        double x = readDouble(scan, "Введите x: "); // Ввод аргумента
        double y = Math.sin(x);                     // Вычисление sin(x)

        while (Math.abs(y) >= 1e-4) {               // Проверка условия остановки
            y = Math.sin(y);                        // Повторное применение sin
        }

        System.out.println("y = " + y);             // Вывод результата
    }

    // Ввод вещественного числа с проверкой
    private static double readDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);              // Вывод сообщения

            if (!scanner.hasNextDouble()) {         // Проверка корректности ввода
                System.out.println("Ошибка: требуется вещественное число.");
                scanner.next();                     // Очистка некорректного ввода
                continue;
            }

            return scanner.nextDouble();             // Возврат введенного числа
        }
    }

    // Поиск первого числа Фибоначчи, превышающего m
    private static void fibonacciTask(Scanner scan) {
        int m = readPositiveNumber(scan, "Введите m: "); // Ввод числа m

        int f0 = 1; // Первое число Фибоначчи
        int f1 = 1; // Второе число Фибоначчи
        int f = 1;  // Текущее число Фибоначчи

        while (f <= m) {     // Поиск числа, превышающего m
            f = f0 + f1;     // Вычисление следующего числа
            f0 = f1;         // Сдвиг значений
            f1 = f;
        }

        System.out.println("Первое число Фибоначчи: " + f); // Вывод результата
    }

    // Вывод простых делителей числа
    private static void primeDivisorsTask(Scanner scan) {
        int n = readPositiveNumber(scan, "Введите натуральное число: "); // Ввод числа

        System.out.print("Простые делители: "); // Заголовок вывода

        for (int i = 2; i <= n; i++) {           // Перебор возможных делителей
            while (n % i == 0) {                 // Проверка делимости
                System.out.print(i + " ");       // Вывод делителя
                n /= i;                          // Деление числа на делитель
            }
        }

        System.out.println();                    // Переход на новую строку
    }

    // Ввод положительного целого числа
    private static int readPositiveNumber(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);           // Вывод сообщения

            if (!scanner.hasNextInt()) {         // Проверка типа ввода
                System.out.println("Ошибка: требуется целое число.");
                scanner.next();                  // Очистка ввода
                continue;
            }

            int value = scanner.nextInt();       // Считывание числа

            if (value <= 0) {                    // Проверка на положительность
                System.out.println("Ошибка: число должно быть положительным.");
                continue;
            }

            return value;                        // Возврат корректного значения
        }
    }
}