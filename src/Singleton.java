public class Singleton {

    private static Singleton instance;

    private Singleton(){
    }

    public static Singleton getInstane(){
        if (instance == null) {
            instance =  new Singleton();
        }
        return instance;
    }
}
