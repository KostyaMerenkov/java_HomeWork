import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Random rand = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //String computer = words[rand.nextInt(words.length-1)];
        //System.out.println(computer);
        guessGame(words, words[rand.nextInt(words.length-1)]);
    }

    public static void checkAnswer(String[] words, char[] help, String person, String computer) {
        if (person.length() > computer.length()) {
            for (int i = 0; i < computer.length(); i++) {
                if (person.charAt(i) == computer.charAt(i)) {
                    help[i] = person.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < person.length(); i++) {
                if (person.charAt(i) == computer.charAt(i)) {
                    help[i] = person.charAt(i);
                }
            }
        }
    }

    public static void guessGame(String[] words, String computer) {
        char[] help = new char[15];
        for(int i=0; i<help.length; i++)
        { help[i] = '#'; }
        String person;
        do {
            onScreen(help);
            System.out.println("Угадайте загаданное слово!");
            person = scanner.nextLine();
            checkAnswer(words, help, person, computer);
        } while(!person.equals(computer));
        System.out.println("Вы угадали!\nЗагаданное компьютером слово: " + computer);
    }

    public static void onScreen(char[] arr) {
        System.out.println();
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}