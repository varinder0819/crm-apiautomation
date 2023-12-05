package JavaDemo;

public class EncapsulationAccess {

    Encapsulationdemo encapsulationdemo;
    EncapsulationAccess(){
        encapsulationdemo = new Encapsulationdemo();
        encapsulationdemo.setDOB(1908);
        System.out.println(encapsulationdemo.getDOB());

    }



    public static void main(String[] args) {
     Encapsulationdemo encapsulationdemo = new Encapsulationdemo();
        encapsulationdemo.setname(" Varinder");
        encapsulationdemo.setDOB(1980);
        encapsulationdemo.setLastname("Bedi");
       // encapsulationdemo.setM(true);
        System.out.println(encapsulationdemo.getDOB());
        System.out.println(encapsulationdemo.getLastname());
        System.out.println(encapsulationdemo.getName());



    }
}
