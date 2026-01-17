public class Platypus extends Mammal {

    private boolean venomous;
    private double beakLength;

    public Platypus(String name, int age, double weight, boolean venomous, double beakLength) {
        super(name, age, weight);
        this.venomous = venomous;
        this.beakLength = beakLength;
    }

    @Override
    public void reproduce (){
        System.out.println(name + " откладывает яйца.");
    }

    public void showPlatypusInfo() {
        showInfo();
        System.out.println(
            "Ядовитый: " + (venomous ? "да" : "нет") +
            ". Длина клюва: " + beakLength + " см."
        );
    }
}
