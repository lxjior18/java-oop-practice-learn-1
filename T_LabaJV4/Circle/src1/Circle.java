// Класс Circle, описывающий окружность на плоскости
public class Circle {

    private double x; // Координата x центра окружности
    private double y; // Координата y центра окружности
    private double r; // Радиус окружности

    // Конструктор класса Circle
    public Circle(double x, double y, double r) {
        this.x = x; // Инициализация координаты x
        this.y = y; // Инициализация координаты y
        this.r = r; // Инициализация радиуса
    }

    // Вычисляет длину окружности
    public double getLenght() {
        return 2 * Math.PI * r; // Формула длины окружности
    }

    // Вычисляет расстояние между центрами двух окружностей
    public double distanceTo(Circle other) {
        double dx = this.x - other.x; // Разность координат x
        double dy = this.y - other.y; // Разность координат y
        return Math.sqrt(dx * dx + dy * dy); // Евклидово расстояние
    }

    // Выводит информацию об окружности в форматированном виде
    public void printInfo() {
        System.out.printf(
                "Центр (%.0f | %.0f), R = %.1f, длина = %.1f%n",
                x, y, r, getLenght()
        ); // Форматированный вывод данных
    }
}