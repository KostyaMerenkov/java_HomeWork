package animals;

public class Dog extends Animal{
    private static int dogCount;

    public static void getDogCount() {
        System.out.println("Количество собак: " + dogCount);
    }

    public Dog(String name, String color, int age) {
        super(name, color, age);
        dogCount++;
    }

    @Override
    public void run(int meters) {
        if(meters > 500) {
            System.out.printf("%s не может пробежать  %dм!\n", name, meters);
        }
        else    {
            super.run(meters);
        }
    }

    @Override
    public void swim(int meters) {
        if(meters > 10) {
            System.out.printf("%s не может проплыть  %dм!\n", name, meters);
        }
        else    {
            super.swim(meters);
        }
    }
}
