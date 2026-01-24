package scr2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Нахождение наибольшего общего делителя
    public static void gcdTask(Scanner scan) {
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
    public static int gcd(int a, int b) {
        while (b != 0) {      // Пока второе число не равно нулю
            int r = a % b;    // Остаток от деления
            a = b;            // Присваивание нового значения a
            b = r;            // Присваивание нового значения b
        }
        return a;             // Возврат НОД
    }

    // Ввод положительного целого числа
    public static int readPositiveNumber(Scanner scanner, String message) {
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
