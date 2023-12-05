package JavaDemo;

import java.util.ArrayList;

public class ListDemo {

    public static void main(String[] args) {
        // list of hetrogenous objects { 10, 10.9, "varinder", true, h}
        ArrayList arraylist = new ArrayList();
        arraylist.add(100);
        arraylist.add(10.9);
        arraylist.add("varinder Bedi ");
        arraylist.add(true);
        arraylist.add('h');

        for (Object value : arraylist) {
            if (value.getClass().getSimpleName().equals("String")) {
                System.out.println("value of string: " + value);
                String val = value.toString();
                String[] newval = val.split("\\s");
                for (String str : newval) {
                    System.out.println(str);

                }
            }
            else if(value.getClass().getSimpleName().equals("Integer")){

             System.out.println("value of int: " + value);
           }
          else if(value.getClass().getSimpleName().equals("Boolean")){

             System.out.println("value of Boolean: " + value);
          }
            else if(value.getClass().getSimpleName().equals("Character")){

                System.out.println("value of Character: " + value);
            }
            else if(value.getClass().getSimpleName().equals("Decimal")){

                System.out.println("value of Character: " + value);
            }



        }
        //homegenous array
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Firstname");
        arrayList1.add("Last name");
        for(int i = 0;i<arrayList1.size();i++){
         System.out.println(arrayList1.get(i));
            
        }


    }
    // homegenous array list




}


