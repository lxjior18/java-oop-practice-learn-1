// Класс IsoscelesTriangle, представляющий равнобедренный треугольник
public class IsoscelesTriangle extends Triangle {

    // Конструктор класса IsoscelesTriangle
    public IsoscelesTriangle(double a, double b, double c) {
        super(a, b, c); // Вызов конструктора родительского класса
    }

    // Проверяет, является ли треугольник равнобедренным
    public boolean isIsosceles() {
        return exists() && (a == b || a == c || b == c); // Проверка равенства сторон
    }

    // Выводит информацию о равнобедренном треугольнике
    @Override
    public void printInfo() {
        if (!isIsosceles()) {
            System.out.println("Не равнобедренный треугольник"); // Сообщение об ошибке
            return;
        }
        System.out.print("Равнобедренный "); // Уточнение типа треугольника
        super.printInfo();                   // Вызов метода родительского класса
    }
}