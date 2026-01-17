import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println(
            "Выберите способ задания треугольников:\n" +
            "1 - случайные значения\n" +
            "2 - ввод с клавиатуры"
        );

        byte choice = scan.nextByte();

        int N = readPositiveInt(scan, "Введите количество треугольников N: ");
        int M = readPositiveInt(scan, "Введите количество равнобедренных M: ");

        Triangle[] triangles = new Triangle[N];
        IsoscelesTriangle[] isoTriangles = new IsoscelesTriangle[M];

        switch (choice) {

            // ---------- СЛУЧАЙНЫЕ ДАННЫЕ ----------
            case 1:
                for (int i = 0; i < N; i++) {
                    double a = 2 + random.nextDouble() * 8;
                    double b = 2 + random.nextDouble() * 8;
                    double c = 2 + random.nextDouble() * 8;

                    triangles[i] = new Triangle(a, b, c);
                }

                for (int i = 0; i < M; i++) {
                    double a = 2 + random.nextDouble() * 8;
                    double b = a;
                    double c = 2 + random.nextDouble() * 8;

                    isoTriangles[i] = new IsoscelesTriangle(a, b, c);
                }
                break;

            // ---------- ВВОД С КЛАВИАТУРЫ ----------
            case 2:
                for (int i = 0; i < N; i++) {
                    System.out.println("\nТреугольник " + (i + 1));
                    double a, b, c;

                    while (true) {
                        a = readPositiveDouble(scan, "Введите сторону a: ");
                        b = readPositiveDouble(scan, "Введите сторону b: ");
                        c = readPositiveDouble(scan, "Введите сторону c: ");

                        Triangle t = new Triangle(a, b, c);
                        if (t.exists()) {
                            triangles[i] = t;
                            break;
                        } else {
                            System.out.println("Такой треугольник не существует. Повторите ввод.");
                        }
                    }
                }

                for (int i = 0; i < M; i++) {
                    System.out.println("\nРавнобедренный треугольник " + (i + 1));
                    double a, c;

                    while (true) {
                        a = readPositiveDouble(scan, "Введите равные стороны a и b: ");
                        c = readPositiveDouble(scan, "Введите основание c: ");

                        IsoscelesTriangle t = new IsoscelesTriangle(a, a, c);
                        if (t.isIsosceles()) {
                            isoTriangles[i] = t;
                            break;
                        } else {
                            System.out.println("Ошибка: треугольник не является равнобедренным.");
                        }
                    }
                }
                break;

            default:
                System.out.println("Неверный выбор.");
                return;
        }

        // ---------- ВЫВОД ----------
        System.out.println("\nТреугольники:");
        double sumArea = 0;

        for (Triangle t : triangles) {
            t.printInfo();
            sumArea += t.getArea();
            System.out.println();
        }

        double avgArea = sumArea / N;
        System.out.printf("Средняя площадь треугольников: %.1f%n", avgArea);

        // ---------- МИНИМАЛЬНАЯ ПЛОЩАДЬ ----------
        IsoscelesTriangle min = isoTriangles[0];
        for (int i = 1; i < isoTriangles.length; i++) {
            if (isoTriangles[i].getArea() < min.getArea()) {
                min = isoTriangles[i];
            }
        }

        System.out.println("\nРавнобедренный треугольник с минимальной площадью:");
        min.printInfo();
    }

    // ---------- ВВОД int ----------
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
            System.out.println("Ошибка: число должно быть больше 0.");
            continue;
        }

        return value;
        }
    }
    
}