package JavaDemo;
/*  1 2 3 4
    5 6 7
    8 9
    10
 */
public class NestedForLoop {
    public static void main(String[] args) {
        for(int i =1;i<=4;i++){ // 2
            for(int j=1;j<=4;j++){
                System.out.println(j);// 1 2 3 4
            }

        }
    }
}
