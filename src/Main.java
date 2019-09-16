import java.util.Scanner;

public class Main {

    static int number = 12342890;
    double floatingpointnumber = 123.12312;
    char character = 'a';
    boolean value = true;

    static String greeting = "hello ";

    public static void main(String[] args) {
        System.out.println("please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("please enter your age: ");
        int age = scanner.nextInt();
        Human human = new Human();
        human.name = name;
        human.age = age;
        System.out.println(greeting + human.name + " your age is: " + human.age);
    }
}
