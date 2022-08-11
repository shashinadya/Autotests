package Animals;

public class Horse extends Animal {

    String horseNickname;
    String horseBreed;
    int horseAge;

    @Override
    public void makeNoise() {
        System.out.println("игого");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест сено.");
    }

    @Override
    public void sleep() {
        System.out.println("Лошадь спит.");
    }
}
