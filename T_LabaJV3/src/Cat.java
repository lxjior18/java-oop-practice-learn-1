// Класс Cat, наследующий свойства и методы класса Mammal
public class Cat extends Mammal {

    private String color;    // Цвет шерсти животного
    private boolean indoor;  // Признак домашнего содержания

    // Конструктор класса Cat
    public Cat(String name, int age, double weight, String color, boolean indoor){
        super(name, age, weight); // Вызов конструктора родительского класса
        this.color = color;       // Инициализация цвета шерсти
        this.indoor = indoor;     // Инициализация признака домашнего животного
    }

    // Вывод информации о кошке
    public void showCatInfo() {
        showInfo(); // Вывод общей информации из класса Mammal
        System.out.println("Цвет шерсти: " + color + "."); // Вывод цвета шерсти
        System.out.println("Домашняя: " + (indoor ? "да." : "нет.")); // Вывод признака домашнего содержания
    }
}
