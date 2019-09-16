import java.util.ArrayList;
import java.util.List;





public class Arrays {

    public static void main(String[] args) {
        int[] ar1 = {1,2,3};
        int[] ar2 = {1,2,3};
        int ar3[] = {1,2,3};

        System.out.println(ar1.getClass().getSimpleName());
        System.out.println(ar1 instanceof  Object);
        System.out.println(ar1.equals(ar2));
        System.out.println(ar1.equals(ar3));
        //System.out.println(ar1[ar1.length]);

        //definition of array? data / duplicates
        //Ordered List that allowes duplicates

        //store an Integer and a String in one Array
        List<String> arSI = new ArrayList<>();


        arSI.add("Hallo Marco");
        arSI.add(Integer.toString(25));
        System.out.println(arSI);


        //change size of array?
        List<String> arSII = arSI;
        System.out.println(arSI.size());
        arSI.remove(1);
        System.out.println(arSI.size());
        System.out.println(arSII.size());

        Immutable imu = new Immutable("Alexey");
        System.out.println(imu);
        imu = new Immutable("Alexey");
        System.out.println(imu);

        arSI.add("asdlk");
        for(String s : arSI){
            arSI.add(s);
        } //TODO linked list - list

        
    }

    static final class Immutable {
        private final String wert;

        public Immutable(String wert) {
            this.wert = wert;
        }

        public String getWert(){
            return wert;
        }
    }
}
