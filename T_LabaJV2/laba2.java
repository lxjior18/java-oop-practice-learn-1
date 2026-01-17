import java.util.Random;   // Класс для генерации случайных чисел
import java.util.Scanner;  // Класс для ввода данных с клавиатуры

public class laba2 {

    // Главный метод программы
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Создание объекта Scanner

        System.out.println("Выберите задание:"); // Вывод меню
        System.out.println("1 - Двумерный массив 5x8");
        System.out.println("2 - Массив из n и чётные элементы");

        byte choice = scan.nextByte(); // Считывание выбора пользователя

        switch (choice) { // Выбор выполняемого задания
            case 1:
                twoDimArrayTask(); // Вызов задания с двумерным массивом
                break;
            case 2:
                evenArrayTask(scan); // Вызов задания с одномерным массивом
                break;
            default:
                System.out.println("Неверный выбор"); // Обработка ошибочного ввода
        }
    }

    // Создание, заполнение и обработка двумерного массива 5x8
    private static void twoDimArrayTask() {
        Random random = new Random(); // Генератор случайных чисел

        int[][] array = new int[5][8]; // Объявление двумерного массива
        int max = -99;                 // Начальное значение максимума

        // Заполнение массива и поиск максимального элемента
        for (int i = 0; i < array.length; i++) {          // Перебор строк
            for (int j = 0; j < array[i].length; j++) {   // Перебор столбцов
                array[i][j] = random.nextInt(199) - 99;   // Заполнение случайным числом

                if (array[i][j] > max) {                  // Сравнение с максимумом
                    max = array[i][j];                    // Обновление максимума
                }
            }
        }

        System.out.println("Двумерный массив:"); // Заголовок вывода

        // Вывод двумерного массива
        for (int i = 0; i < array.length; i++) {          // Перебор строк
            for (int j = 0; j < array[i].length; j++) {   // Перебор столбцов
                System.out.printf("%4d", array[i][j]);    // Форматированный вывод элемента
            }
            System.out.println();                          // Переход на новую строку
        }

        System.out.println("Максимальный элемент массива: " + max); // Вывод максимума
    }

    // Формирование массива из n элементов и массива чётных значений
    private static void evenArrayTask(Scanner scan) {
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
