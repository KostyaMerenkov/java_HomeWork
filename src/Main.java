
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat cats[] = new Cat[8];
        cats[0] = new Cat("Barsik");
        cats[1] = new Cat("Murka");
        cats[2] = new Cat("Abbie");
        cats[3] = new Cat("Томас");
        cats[4] = new Cat("Caeser");
        cats[5] = new Cat("Gaia");
        cats[6] = new Cat("Walt");
        cats[7] = new Cat("Yashi");

        Plate plate = new Plate(100);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.println(plate);
        }
        System.out.println();
        for (int i = 0; i < cats.length; i++) {
            if(cats[i].isSatiety()) {
                System.out.println(cats[i].getName() + " сыт");
            }
            else {
                System.out.println(cats[i].getName() + " не сыт");
            }
        }
        System.out.println();

        plate.addFood(50);
        cats[6].eat(plate);
        cats[7].eat(plate);

        Dog dog = new Dog("Buldog");
        dog.scare(cats[1]);


    }
}
