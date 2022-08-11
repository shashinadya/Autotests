package Animals;

public class Cat extends Animal {

    String catNickname;
    String catBreed;
    int catAge;

    @Override
    public void makeNoise() {
        System.out.println("мяу-мяу");
    }

    @Override
    public void eat() {
        System.out.println("Кошка пьет молоко.");
    }

    @Override
    public void sleep() {
        System.out.println("Кошка спит.");
    }
}
