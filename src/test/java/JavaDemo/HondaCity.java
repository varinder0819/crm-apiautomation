package JavaDemo;

public class HondaCity implements Car{

    public void engine() {
        System.out.println("1400 cc engine");
    }

    public void wheels() {
        System.out.println("MRF 16 inches");
    }

    public void color() {
        System.out.println("Red");
    }

    public void fueltype() {
        System.out.println("Special fuel ");
    }

    @Override
    public void gears() {
        System.out.println("normal gear");
    }
    public void bootspace(){
        
    }

    public static void main(String[] args) {
        HondaCity hondacity = new HondaCity();
        hondacity.color();
        hondacity.engine();
        hondacity.fueltype();
        hondacity.wheels();
        hondacity.gears();
        Car.bootpace();
        System.out.println(Car.a);

    }


}
