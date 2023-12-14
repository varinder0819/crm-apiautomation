package com.api.automation.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class LoginPart2 {

    @Given("I want to test valid username as {} and password as {}")
    public void iWantToTestValidUsernameAsAndPasswordAs(String username, String password) {
        System.out.println(username + " = " + password);
    }

    @Given("I have valid username as {} and invalid password as {}")
    public void iHaveValidUsernameAsAndInvalidPasswordAs(String uname, String password) {
        System.out.println(uname + "=" + password + "," + " testcase is failed");


    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        System.out.println("test case is passed");

    }

    @Then("I got an error message")
    public void iGotAnErrorMessage() {
        System.out.println("validation failed");
    }

    @Given("I have valid username as {} and empty password as {}")
    public void iHaveValidUsernameAsAndEmptyPasswordAs(String username, String password) {
        System.out.println(username + " = " + password + " ," + "Test case is falied as password is empty");
    }

    @Given("I have added username as blank {} and password also blank as {}")
    public void iHaveAddedUsernameAsBlankAndPasswordAlsoBlankAs(String username, String password) {
        System.out.println(username + "  " + password + "  " + "testcase is failed as both the fields are blank");

    }

    @Given("I have following valid credentials")
    public void iHaveFollowingValidCredentials(List<String> uname) {
        System.out.println(uname);
        uname.forEach((v) -> {
            System.out.println(v);
            ;

        });
    }

    @Given("I have following valid credentials structure")
    public void iHaveFollowingValidCredentialsStructure(DataTable table) {
        System.out.println(table);
        List<Map<String, String>> maps = table.asMaps();
        for (Map<String, String> map : maps) {
            Collection<String> values = map.values();
           // values.forEach((val ->System.out.println(val)));
            values.forEach(System.out::println);


        }
    }

    @Given("I have following login usernames")
    public void iHaveFollowingLoginUsernames(String usernames) {
        System.out.println(usernames);
        for (String data: usernames.split(",")) {
            System.out.println(data.trim());

        }

    }

    @Given("I launch the browser")
    public void iLaunchTheBrowser() {
        System.out.println("Launch browser method");
    }

    @Then("I navigate to website")
    public void iNavigateToWebsite() {
        System.out.println("Navigate website method");
    }
}
