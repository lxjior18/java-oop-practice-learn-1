package scr4;

import java.util.Scanner;

public class Main {

    // Поиск первого числа Фибоначчи, превышающего m
    public static void fibonacciTask(Scanner scan) {
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
