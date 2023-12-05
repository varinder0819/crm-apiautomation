package JavaDemo;

public interface Car {

    static void bootpace(){
        System.out.println("this is part of bootspace");

    }
    static int a =10;

    void engine();
    void wheels();
    void color();

    void fueltype();

    default void gears(){
        System.out.println("special gears");
    }

}
