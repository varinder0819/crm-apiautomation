package com.api.autonmation.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DifferentStructureStepDefinition {
    @Given("I have following browsers")
    //  public void iHaveFollowingBrowsers(List<String> browsers){
    //   System.out.println(browsers);

    //    List<String> browser = new ArrayList<>();
    // System.out.println(browsers);
    // Print the values one by one
    public void iHaveFollowingBrowsers(DataTable table) {
        System.out.println(table);
        List<Map<String, String>> maps = table.asMaps();
        for (Map<String, String> map : maps) {
            Collection<String> data = map.values();
            //      data.forEach((val)->{
            //      System.out.println(val);
            //  });
            //     data.forEach(val-> System.out.println(val));
            data.forEach(System.out::println);


        }
    }

    @Given(": I have following gadgets")
    public void iHaveFollowingGadgets(String gadgets) {
        System.out.println(gadgets);

      //  String[] gdg = gadgets.split(" ");

        for (String var : gadgets.split(" ")) {
            System.out.println(var.trim());


        }
    }


}
