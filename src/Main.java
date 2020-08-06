import animals.*;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Musua", "black", 1);
        Dog dog = new Dog("Marselka", "orange", 2);

        dog.run(5);
        dog.run(505);
        cat.run(100);
        cat.run(250);
        dog.swim(5);
        dog.swim(25);
        cat.swim(100);
        Animal.getAnimalCount();
        Cat.getCatCount();
        Dog.getDogCount();
    }
}