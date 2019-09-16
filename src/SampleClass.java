
public class SampleClass {

    public SampleClass() {
        System.out.println("constructor");
    }

    {
        System.out.println("nonstatic initialiser");
    }

    static {
        System.out.println("static initialiser");
    }

    // what will be printed on screen when method main executed?
    public static void main(String[] args) {
        System.out.println("main1");
        SampleClass sampleClass;
        System.out.println("main2");
        sampleClass = new SampleClass();
        sampleClass.fancyMethod();
    }

    public void fancyMethod() {
        System.out.println("fancy method");
    }

}
