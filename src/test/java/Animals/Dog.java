package Animals;

public class Dog extends Animal {

    String dogNickname;
    String dogBreed;
    int dogAge;

    @Override
    public void makeNoise() {
        System.out.println("гав-гав");
    }

    @Override
    public void eat() {
        System.out.println("Собака ест кость.");
    }

    @Override
    public void sleep() {
        System.out.println("Собака спит.");
    }
}
