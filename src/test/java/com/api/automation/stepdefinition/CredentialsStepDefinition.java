package com.api.automation.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CredentialsStepDefinition {
    @Given("I entered valid uname as {}")
    public void iEnteredValidUnameAs(String uname) {
        System.out.println(uname);
    }

    @And("I entered valid pwd as {}")
    public void iEnteredValidPwdAs(String pwd) {
        System.out.println(pwd);
    }


    @Given("I entered username and password")
    public void iEnteredUsernameAndPassword() {

    }

    @And("user redirects to the page")
    public void userRedirectsToThePage() {
    }

    @Given("I have added following uname and pwd")
    public void iHaveAddedFollowingUnameAndPwd(DataTable table) {
        System.out.println(table);
    }

    @Given("I have below browsers")
    public void iHaveBelowBrowsers(DataTable table) {
        System.out.println(table);
        List<Map<String, String>> maps = table.asMaps();
        for (Map<String, String> map : maps) {
            Collection<String> values = map.values();
            values.forEach((v) -> {
                System.out.println(v);

            });


        }


    }

    @Given("I have following assets")
    public void iHaveFollowingAssets(List<String> assets) {
        System.out.println(assets);

        assets.forEach((val) -> {
            System.out.println(val);

        });
    }

    @Given("I have horizontal data to display for the employee")
    public void iHaveHorizontalDataToDisplayForTheEmployee(Map<String, String> data) {
        System.out.println(data);

        data.forEach((k, v) -> {
            System.out.println(k+" "+v);

        });
    }
}

