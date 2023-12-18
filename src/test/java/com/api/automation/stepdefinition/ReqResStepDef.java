package com.api.automation.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ReqResStepDef {
    RequestSpecification specification;
    Response response;

    @Given("I setup the request structure to fetch all user information")
    public void setup(){
        specification = RestAssured.given();

        specification.baseUri("https://reqres.in/")
                .basePath("/api")
                .queryParam("page","2")
                .header("Accept","application/json")
                .log().all();

    }

    @When("I hit a get all user api")
    public void iHitAGetAllUserApi() {
        response= specification.get("/users");
    }

    @Then("I verify response")
    public void iVerifyResponse() {

        Assert.assertEquals(200, response.getStatusCode());

        response.prettyPrint();

        //get id of each user
        List<Object> ids =response.jsonPath().getList("data.id");

        System.out.println(ids);

        //get email id of all users
        List<Object> emaiIds= response.jsonPath().getList("data.email");
        System.out.println(emaiIds);

        //get the name of id 1
        String fName= response.jsonPath().getString("data[0].first_name");
        System.out.println(fName);

        //get the id of first user along with name
       Map<String,Object> firstUserDetails=  response.jsonPath().getMap("data[0]");
        System.out.println("Id: "+ firstUserDetails.get("id"));
        System.out.println("first_name: "+ firstUserDetails.get("first_name"));
        System.out.println("last_name: "+ firstUserDetails.get("last_name"));

        //get entire response
        Map<String,Object> resp1=  response.jsonPath().get("");
        System.out.println(resp1);

        Map<String,Object> resp2=response.jsonPath().getMap("");
        System.out.println(resp2);

        Object  resp3 =response.jsonPath().getJsonObject("");
        System.out.println(resp3);

        Assert.assertEquals(2, response.jsonPath().getLong("page") );
    }

    @And("I want to extract all ids")
    public void iWantToExtractAllIds() {

        List<Object> list = response.jsonPath().getList("data.id");
        System.out.println(list);
        // for(String,Object object : list)

    }
}
