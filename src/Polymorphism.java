public class Polymorphism {

    //what will be printed on screen when main method is executed?
    public static void main (String[] args){
        A a = new B();
        a.method();
    }
}

class A {
    void method (){
        System.out.println("A");
    }
}

class B extends A {
    @Override
    void method (){
        System.out.println("B");
    }
}
