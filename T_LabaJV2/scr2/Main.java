package scr2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    
       // Формирование массива из n элементов и массива чётных значений
    public static void evenArrayTask(Scanner scan) {
        Random random = new Random(); // Генератор случайных чисел

        int n = readMoreThanThree(scan, "Введите натуральное число n (>3): "); // Ввод размера массива

        int[] array = new int[n]; // Объявление массива длины n

        // Заполнение массива случайными числами
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n + 1); // Генерация числа от 0 до n
        }

        System.out.println("Исходный массив:"); // Заголовок вывода

        // Вывод исходного массива
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " "); // Печать элемента массива
        }
        System.out.println();

        int countEven = 0; // Счётчик чётных элементов

        // Подсчёт количества чётных элементов
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) { // Проверка на чётность
                countEven++;
            }
        }

        // Формирование массива чётных элементов
        if (countEven > 0) {
            int[] evenArray = new int[countEven]; // Массив для чётных элементов
            int index = 0;                         // Индекс для заполнения массива

            for (int i = 0; i < n; i++) {
                if (array[i] % 2 == 0) {           // Проверка на чётность
                    evenArray[index] = array[i];  // Добавление элемента
                    index++;                       // Увеличение индекса
                }
            }

            System.out.println("Массив из чётных элементов:"); // Заголовок вывода

            // Вывод массива чётных элементов
            for (int i = 0; i < evenArray.length; i++) {
                System.out.print(evenArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Чётных элементов нет."); // Сообщение при отсутствии чётных чисел
        }
    }
    
        // Ввод целого числа, большего 3, с проверкой корректности
    private static int readMoreThanThree(Scanner scanner, String message) {
        int value; // Переменная для хранения вводимого значения

        while (true) {
            System.out.print(message); // Вывод приглашения к вводу

            if (!scanner.hasNextInt()) { // Проверка типа ввода
                System.out.println("Ошибка: нужно ввести целое число.");
                scanner.next();          // Очистка некорректного ввода
                continue;
            }

            value = scanner.nextInt();   // Считывание числа

            if (value <= 3) {            // Проверка условия задачи
                System.out.println("Ошибка: число должно быть больше 3.");
                continue;
            }

            return value;                // Возврат корректного значения
        }
    }
}
