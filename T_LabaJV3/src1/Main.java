import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println(
            "Выберите способ ввода данных:\n" +
            "1 - случайные данные\n" +
            "2 - ввод с клавиатуры"
        );

        byte choice = scan.nextByte();

        int N = readPositiveInt(scan, "Введите количество окружностей N: ");
        int M = readPositiveInt(scan, "Введите количество цилиндров M: ");

        Circle[] circles = new Circle[N];
        Cylinder[] cylinders = new Cylinder[M];

        switch (choice) {
            case 1:
                // случайные данные
                for (int i = 0; i < N; i++) {
                    double R = 1 + random.nextDouble() * 9;
                    circles[i] = new Circle(R);
                }

                for (int i = 0; i < M; i++) {
                    double R = 1 + random.nextDouble() * 9;
                    double h = 1 + random.nextDouble() * 9;
                    cylinders[i] = new Cylinder(R, h);
                }
                break;

            case 2:
                // ввод с клавиатуры
                for (int i = 0; i < N; i++) {
                    double R = readPositiveDouble(scan, "Введите радиус окружности " + (i + 1) + ": ");
                    circles[i] = new Circle(R);
                }

                for (int i = 0; i < M; i++) {
                    double R = readPositiveDouble(scan, "Введите радиус цилиндра " + (i + 1) + ": ");
                    double h = readPositiveDouble(scan, "Введите высоту цилиндра " + (i + 1) + ": ");
                    cylinders[i] = new Cylinder(R, h);
                }
                break;

            default:
                System.out.println("Неверный выбор.");
                return;
        }

        // вывод окружностей
        System.out.println("\nОкружности:");
        for (Circle c : circles) {
            c.printInfo();
        }

        // вывод цилиндров
        System.out.println("\nЦилиндры:");
        for (Cylinder c : cylinders) {
            c.printInfo();
        }

        // окружность с максимальной площадью
        Circle maxCircle = circles[0];
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].getArea() > maxCircle.getArea()) {
                maxCircle = circles[i];
            }
        }

        System.out.println("\nОкружность с максимальной площадью:");
        maxCircle.printInfo();

        // средний объем цилиндров
        double sum = 0;
        for (Cylinder c : cylinders) {
            sum += c.getVolume();
        }

        double avgVolume = sum / M;
        System.out.printf("\nСредний объем цилиндров: %.1f", avgVolume);
    }

    // ---------- проверки ввода ----------

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
            return value;
        }
    }

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
                System.out.println("Ошибка: значение должно быть больше 0.");
                continue;
            }
            return value;
        }
    }
}