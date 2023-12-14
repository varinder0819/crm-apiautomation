package com.api.automation.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;


public class LoginStepDefinition {

    @Given("I launch the browser and navigate to the website")
    public void lunchTheBrowser() {
        System.out.println("Browser launched");

    }

    @When("I entered username and pasword")
    public void iEnteredUsernameAndPasword() {
        System.out.println("Entered uname and pwd");

    }

    @And("I clicked on login button")
    public void iClickedOnLoginButton() {
        System.out.println("clicked on login button");

    }

    @Then("I logged into the application")
    public void iLoggedIntoTheApplication() {
        System.out.println("successfully logged into the application");

    }

    @When("I clicked on Logo")
    public void iClickedOnLogo() {
        System.out.println("Logo is clicked");

    }

    @When("I entered incorret username and pasword")
    public void iEnteredIncorretUsernameAndPasword() {
        System.out.println("Invalid uname and pwd entered");

    }

    @Then("I got error message")
    public void iGotErrorMessage() {
        System.out.println("Got an error message");
    }

    @Given("All employee information is added")
    public void allEmployeeInformationIsAdded(DataTable table) {
        System.out.println(table);

        List<Map<String, String>> data = table.asMaps();
        for (Map<String, String> obj : data) {
            //    System.out.println(obj);
            obj.forEach((k, v) -> {
                System.out.println(k + " " + v);
            });
        }


    }


    @Given("I enter unames as {}")
    public void iEnterUnamesAs(String ume) {
        System.out.println("Unames:" + ume);
    }

    @And("I enter pwds as {}")
    public void iEnterPwdsAs(String pd) {
        System.out.println("pwd:" + pd);
    }


    @Given("I create employee using following information")
    public void iCreateEmployeeUsingFollowingInformation(Map<String, String> data) {
      //  System.out.println(data);
        data.forEach((k, v) -> {
            System.out.println(k+" "+v);
        });
    }
}
