public class TrueFalse {

    // what will be printed on screen when method main executed?
    public static void main(String[] args) {

        if (giveMeTrue1() && giveMeFalse1() && giveMeTrue2() && giveMeFalse2()) {
            System.out.println("it's true!");
        } else {
            System.out.println("it's false!");
        }
    }

    private static boolean giveMeTrue1() {
        System.out.println("giveMeTrue1");
        return true;
    }

    private static boolean giveMeTrue2() {
        System.out.println("giveMeTrue2");
        return true;
    }

    private static boolean giveMeFalse1() {
        System.out.println("giveMeFalse1");
        return false;
    }

    private static boolean giveMeFalse2() {
        System.out.println("giveMeFalse2");
        return false;
    }

}
