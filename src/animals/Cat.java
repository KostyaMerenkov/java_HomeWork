package animals;

public class Cat extends Animal{
    private static int catCount;

    public static void getCatCount() {
        System.out.println("Количество кошек: " + catCount);
    }

    public Cat(String name, String color, int age) {
        super(name, color, age);
        catCount++;
    }

    @Override
    public void run(int meters) {
        if(meters > 200) {
            System.out.printf("%s не может пробежать  %d м!\n", name, meters);
        }
        else    {
            super.run(meters);
        }
    }

    @Override
    public void swim(int meters) {
        System.out.printf("%s не умеет плавать!\n", name);
    }
}
