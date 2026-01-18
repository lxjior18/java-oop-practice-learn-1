// Класс Platypus, наследующий свойства и методы класса Mammal
public class Platypus extends Mammal {

    private boolean venomous;     // Признак наличия яда
    private double beakLength;    // Длина клюва в сантиметрах

    // Конструктор класса Platypus
    public Platypus(String name, int age, double weight,
                    boolean venomous, double beakLength) {
        super(name, age, weight); // Вызов конструктора родительского класса
        this.venomous = venomous; // Инициализация признака ядовитости
        this.beakLength = beakLength; // Инициализация длины клюва
    }

    // Переопределение способа размножения
    @Override
    public void reproduce() {
        System.out.println(name + " откладывает яйца."); // Вывод сообщения
    }

    // Вывод информации об утконосе
    public void showPlatypusInfo() {
        showInfo(); // Вывод общей информации из класса Mammal
        System.out.println(
                "Ядовитый: " + (venomous ? "да" : "нет") +
                ". Длина клюва: " + beakLength + " см."
        ); // Вывод специфических характеристик
    }
}