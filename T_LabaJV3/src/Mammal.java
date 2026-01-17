// Базовый класс Mammal, описывающий млекопитающее
public class Mammal {

    protected String name;    // Имя животного
    protected int age;        // Возраст животного
    protected double weight;  // Масса животного

    // Конструктор класса Mammal
    public Mammal(String name, int age, double weight) {
        this.name = name;     // Инициализация имени
        this.age = age;       // Инициализация возраста
        this.weight = weight; // Инициализация массы
    }

    // Метод, описывающий кормление детёнышей
    public void feedBaby() {
        System.out.println(name + " кормит детенышей молоком."); // Вывод сообщения
    }

    // Метод, описывающий процесс размножения
    public void reproduce() {
        System.out.println(name + " рождает детенышей."); // Вывод сообщения
    }

    // Вывод общей информации о млекопитающем
    public void showInfo() {
        System.out.println("Имя: " + name);              // Вывод имени
        System.out.println("Возраст: " + age + ".");     // Вывод возраста
        System.out.println("Вес: " + weight + " кг.");   // Вывод массы
    }
}
