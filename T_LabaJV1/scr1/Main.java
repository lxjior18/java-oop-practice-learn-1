package scr1;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        int a, b, c; // Переменные для сторон треугольника

        System.out.println(
                "Выбор решения задачи:\n" +
                "1 - случайные стороны\n" +
                "2 - произвольные стороны"
        );
        Scanner scan = new Scanner(System.in);
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
    public static void isTriangle(int a, int b, int c) {
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
