// Класс Dog, наследующий свойства и методы класса Mammal
public class Dog extends Mammal {

    private String breed;      // Порода собаки
    private boolean trained;   // Признак обучения командам
    private boolean inSpace;   // Признак участия в космических полётах

    // Конструктор класса Dog
    public Dog(String name, int age, double weight,
               String breed, boolean trained, boolean inSpace) {
        super(name, age, weight); // Вызов конструктора родительского класса
        this.breed = breed;       // Инициализация породы
        this.trained = trained;   // Инициализация признака обучения
        this.inSpace = inSpace;   // Инициализация признака пребывания в космосе
    }

    // Вывод информации о собаке
    public void showDogInfo() {
        showInfo(); // Вывод общей информации из класса Mammal
        System.out.println("Порода: " + breed + "."); // Вывод породы
        System.out.println("Обучена командам: " + (trained ? "да." : "нет.")); // Вывод признака обучения
        System.out.println("Была ли в космосе? " + (inSpace ? "да." : "нет.")); // Вывод дополнительной информации
    }
}
