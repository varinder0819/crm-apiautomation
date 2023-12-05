package JavaDemo;

import java.sql.SQLOutput;

public class CallFunInterfaceUsingLamdaRenoldPen {
    public static void main(String[] args) {
        FuctionalInterfacePen fip = new FuctionalInterfacePen() {
            @Override
            public void ink() {
                System.out.println("Implementiing the pen interface");

            }
        };
        fip.ink();

        FuctionalInterfacePen fip1 = () -> {
            System.out.println("lambda");

    };
        fip1.ink();
    }
}
