package scr1;

import java.util.Random;

public class Main {

    // Создание, заполнение и обработка двумерного массива 5x8
    public static void twoDimArrayTask() {
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

}
