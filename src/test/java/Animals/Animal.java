package Animals;

public class Animal {

    String food;
    String location;
    Dog dog;
    Cat cat;
    Horse horse;

    public void makeNoise() {
        System.out.println("Животное издаёт звуки.");
    }

    public void eat() {
        System.out.println("Животное ест.");
    }

    public void sleep() {
        System.out.println("Животное спит.");
    }
}
