package JavaDemo;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Honda {
    public static void main(String[] args) {
        // { Anonymous class};
        Bike bike = new Bike() {
            @Override
            public void engine() {
                System.out.println("1555 cc");
            }
            @Override
            public String color() {
                return "White";
            }
        };
        bike.engine();
        System.out.println(bike.color());
    }
}
