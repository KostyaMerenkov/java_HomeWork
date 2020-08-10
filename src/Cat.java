
public class Cat {
    private String name;
    private boolean satiety;


    public Cat(String name) {
        this.name = name;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {

        if (plate.decreaseFood(15)) {
            satiety = true;
            System.out.println(name + " ate");
        }

    }

    public boolean isSatiety() {
        return satiety;
    }

    public void fear(Dog dog) {
        System.out.println(name +" fear "+ dog.getName());
    }
}
