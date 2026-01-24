package scr3;

import java.util.Scanner;

public class Main {

    // Вычисление последовательности sin
    public static void sinTask(Scanner scan) {
        double x = readDouble(scan, "Введите x: "); // Ввод аргумента
        double y = Math.sin(x);                     // Вычисление sin(x)

        while (Math.abs(y) >= 1e-4) {               // Проверка условия остановки
            y = Math.sin(y);                        // Повторное применение sin
        }

        System.out.println("y = " + y);             // Вывод результата
    }

    // Ввод вещественного числа с проверкой
    public static double readDouble(Scanner scanner, String message) {
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
}
