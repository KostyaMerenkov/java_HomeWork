package animals;

public class Animal {
    protected String name;
    protected String color;
    protected int age;

    private static int animalCount;

    public static void getAnimalCount() {
        System.out.println("Количество животных: " + animalCount);
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        animalCount++;
    }

    public void run(int meters) {
        System.out.printf(name + " пробежала %d м.\n", meters);
    }
    public void swim(int meters) {
        System.out.printf(name + " проплыла %d м.\n", meters);
    }


}
