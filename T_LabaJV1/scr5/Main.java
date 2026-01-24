package scr5;

import java.util.Scanner;

public class Main {

       // Вывод простых делителей числа
    public static void primeDivisorsTask(Scanner scan) {
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
