package JavaDemo;

public class Encapsulationdemo {

    private String name;
    private int DOB;
    private boolean m;

    private String lastname;


    public void setDOB(int DOB) {
        this.DOB = DOB;
    }

    public int getDOB() {
        return DOB;
    }


    public void setM(boolean m) {
        this.m = m;
    }

    public boolean isM() {
        return m;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public void setname(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        String [] a ={};
        EncapsulationAccess.main(a);
        System.out.println("I am in main method");

    }

}
