package com.api.automation.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class CompanyStepDef {
    RequestSpecification specification;
    Response response;

    @Given("I setup the request structure")
    public void setupStructure() {

        specification = RestAssured.given();

        specification.baseUri("https://crmapiautomation.agilecrm.com")
                .basePath("/dev/api/contacts/companies")
                .header("Accept", "application/json")
                .auth().basic("varinderQA@yopmail.com", "g3a1j73r9dv1vsr5oca3gfmmh3")
                .log().all();
    }

    @When("I hit a get all company api")
    public void iHitAGetAllCompanyApi() {

        response = specification.post("/list");

    }

    @Then("I verify all companies information in response")
    public void iVerifyAllCompaniesInformationInResponse() {
        response.prettyPrint();

        //verify status code:
        Assert.assertEquals(200, response.getStatusCode());

        //jsonPath expression to verify response
        List<Object> companyList = response.jsonPath().getList("");

        //get the size of an array to verify total companies
        int size = companyList.size();

        Assert.assertEquals(4, size);

        //iterate companyList and get each object from it then cast it into Map
        for (Object object : companyList) {

            //type casting to convert object into Map
            Map<String, Object> companyObject = (Map<String, Object>) object;

            //get the id value from map
//            String id= companyObject.get("id").toString();
            System.out.println("Id: " + companyObject.get("id"));

        }


    }

    @And("Print company ids whos start values are greater than zero")
    public void printCompanyIdsWhosValuesAreGreaterThanZero() {

        List<Object> compList = response.jsonPath().getList("");

        for (Object obj : compList) {

            Map<String, Object> compMap = (Map<String, Object>) obj;

            Long value = Long.valueOf(compMap.get("star_value").toString());

            //check start value
            if (value > 0) {
                System.out.println("Id of company with start value greater than 0: " + compMap.get("id"));
            }

        }


    }

    @Given("print company ids whose tag has some value")
    public void printCompanyIdsWhoseTagHasSomeValue() {
        List<Object> list = response.jsonPath().getList("");

        for (Object allobjects : list) {
            Map<String, Object> map = (Map<String, Object>) allobjects;
            Object alltags = map.get("tags");
            String tagvalue = alltags.toString();

            if (tagvalue != "[]") {
                System.out.println("Id of company whose tags has some value: " + map.get("id"));
            }
        }
    }

    @And("print all the property value of the company")
    public void printAllThePropertyValueOfTheCompany() {

        List<Object> al = response.jsonPath().getList("");
        System.out.println(al);

    }

    @When("print company ids whose lead_scores are greater then zero")
    public void printCompanyIdsWhoseLead_scoresAreGreaterThenZero() {
        List<Object> list = response.jsonPath().getList("");
        for (Object objectiterate : list) {
            Map<String, Object> mconversion = (Map<String, Object>) objectiterate;
            Long leadScore = Long.valueOf(mconversion.get("lead_score").toString());
            if (leadScore > 0) {
                System.out.println("Id of company whose lead_core values are  greater than 0:" + mconversion.get("id"));

            }

        }


    }

    @When("I print the name of company with id")
    public void iPrintTheNameOfCompanyWithId() {

        List<Object> compList= response.jsonPath().getList(""); // This list method is going to the give the repsonse in the form of list

        for(Object obj :compList){
//expilict type casting
            Map<String,Object> compObject= (Map<String,Object>)obj;

            String id= compObject.get("id").toString();
// we have get the value of properties attribute and convert this into list of maps
             List<Map<String,String>> properties = (List<Map<String,String>>)compObject.get("properties");

             //iterate trhough each property object and check value of name attribute
            // If value of name attribute is "name" then get the value of value attribute

            for(Map<String,String> property :properties){

                if(property.get("name").equals("name")){

                    String compName= property.get("value");

                    System.out.println("Id: "+ id + ", Name: "+ compName);
                }
            }
            // hi there


        }
    }
}


