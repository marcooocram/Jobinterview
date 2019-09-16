
public class SwitchCase {

    public static void main(String[] args) {

        String name= "Name";

        switch (name){
            case "name":
                System.out.println("name");
            case "Name":
                System.out.println("Name");
            case "othername":
                System.out.println("otherName");
            default:
                System.out.println("default");
        }
    }
}
