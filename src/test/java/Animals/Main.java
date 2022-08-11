package Animals;

public class Main {
    public static void treatAnimal(Animal animal) {
        System.out.println(animal.food);
        System.out.println(animal.location);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.dogNickname = "Тузик";
        dog.dogBreed = "дворняга";
        dog.dogAge = 4;
        dog.food = "Кость";
        dog.location = "Москва";

        Cat cat = new Cat();
        cat.catNickname = "Мурка";
        cat.catBreed = "Шотландская";
        cat.catAge = 8;
        cat.food = "Молоко";
        cat.location = "Санкт-Петербург";

        Horse horse = new Horse();
        horse.horseNickname = "Спирит";
        horse.horseBreed = "Ирландский";
        horse.horseAge = 6;
        horse.food = "Сено";
        horse.location = "Казань";


        Animal animals[] = new Animal[]{dog, cat, horse};

        for (int i = 0; i < animals.length; i++) {
            treatAnimal(animals[i]);
        }
    }
}
