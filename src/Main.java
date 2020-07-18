public class Main {
    public static void main(String[] args) {
        //Задание 2
        byte a = 100;
        short b = 32700;
        int c = 21462346;
        long d = 9234892489923442L;
        float e = 3.1f;
        double f = 97838.23;
        char g = 'a';
        boolean h = true;

        //Задание 3
        System.out.println("Answer is: " + expression(5,2.1f,10,2.5f));

        //Задание 4
        System.out.println(is1020(11,15));

        //Задание 5
        isPositive(0);

        //Задание 6
        System.out.println(isPositiveBoolean(-39));

        //Задание 7
        helloName("Сергей");

        //Задание 8
        isLeap(2020);
    }
    public static float expression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
    public static boolean is1020(int a, int b) {
        return (a&b)<20 & (a&b)>10;
    }
    public  static void isPositive(int num) {
        if (num<0) System.out.println("Число отрицательное!");
        else System.out.println("Число положительное!");
    }
    public  static boolean isPositiveBoolean(int num) {
        return (num<0);
    }
    public static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }
    public static void isLeap(int year) {
        if (year%4==0 & (year%400==0 || year%100!=0)) System.out.println("Год високосный!");
        else System.out.println("Год не високосный!");
    }
}
