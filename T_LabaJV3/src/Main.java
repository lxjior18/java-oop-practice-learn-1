public class Main {
    public static void main (String[] args){

        Dog belka = new Dog("Белка", 4, 4.5, "Парсон-рассел-терьер", true, true);
        Dog strelka = new Dog("Стрелка", 3, 5.9, "Джек-рассел-терьер", true, true);
        Cat murka = new Cat("Мурка", 3, 4.1, "Серый", true);
        Platypus frosya = new Platypus("Фрося", 2, 1.7, true, 6.5);

        belka.showDogInfo();
        belka.feedBaby();
        belka.reproduce();

        System.out.println();

        strelka.showDogInfo();
        strelka.feedBaby();
        belka.reproduce();

        System.out.println();

        murka.showCatInfo();
        murka.feedBaby();
        murka.reproduce();

        System.out.println();

        frosya.showPlatypusInfo();
        frosya.feedBaby();
        frosya.reproduce();
    }
}
