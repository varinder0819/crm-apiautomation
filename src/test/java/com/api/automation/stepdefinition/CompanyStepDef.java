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

public class CompanyStepDef {
    RequestSpecification specification;
    Response response;
    String name;
    String url;

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
        List<Object> companyList = response.jsonPath().getList("id");

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

        List<Object> compList = response.jsonPath().getList(""); // This list method is going to the give the repsonse in the form of list

        for (Object obj : compList) {
//expilict type casting
            Map<String, Object> compObject = (Map<String, Object>) obj;

            String id = compObject.get("id").toString();
// we have get the value of properties attribute and convert this into list of maps
            List<Map<String, String>> properties = (List<Map<String, String>>) compObject.get("properties");

            //iterate trhough each property object and check value of name attribute
            // If value of name attribute is "name" then get the value of value attribute

            for (Map<String, String> property : properties) {

                if (property.get("name").equals("name")) {

                    String compName = property.get("value");

                    System.out.println("Id: " + id + ", Name: " + compName);
                }
            }
            // hi there


        }
    }

    @When("I paint the name of company along with id")
    public void iPaintTheNameOfCompanyAlongWithId() {
        List<Object> responselist = response.jsonPath().getList("");
        // first will get the id as it is on root level, itearte the objects and convert it into map
        // and get the id

        for (Object iterateobj : responselist) {
            Map<String, Object> mapdata = (Map<String, Object>) iterateobj;
            // get the id
            String id = mapdata.get("id").toString();
            // now we need the attribute where name equals to name and get the value
            //    Object properties = mapdata.get("properties");
            //    System.out.println("**************** properties:"+ properties);
            List<Map<String, String>> prop = (List<Map<String, String>>) mapdata.get("properties");
            for (Map<String, String> properties : prop) {
                if (properties.get("name").equals("name")) {
                    String companyname = properties.get("value");
                    System.out.println("id of the company:" + id + "name of the company: " + companyname);

                }

            }


        }


    }

    @And("I print id along with owners id")
    public void iPrintIdAlongWithOwnersId() {
//        for (Object ls : list) {
//            Map<String, Object> mpdata = (Map<String, Object>) ls;
//            String id = mpdata.get("id").toString();
//            System.out.println(id);

//        List<Object> list = response.jsonPath().getList("");
//
//        List<Map<String,Object>> obj = response.jsonPath().getList("");
//        for(Map<String,Object> comobject : obj) {
//
//         //   System.out.println(comobject);
//
//            Object idObject = comobject.get("id");
//
//            System.out.println(idObject);
//
//            Object ownerObject= comobject.get("owner");
//
//            Map<String,Object> ownerMap= (Map<String,Object>) ownerObject;
//
//            System.out.println(ownerMap.get("id"));
        // First will get all the response using json path since it is in array form will declare as a list with empty data as we do not now which
        // format inside data it is......
        List<Map<String, Object>> obj = response.jsonPath().getList("");
        //System.out.println(obj);
        Map<String, Object> firstobj = obj.get(0);
        Map<String, Object> secondobj = obj.get(1);
        Map<String, Object> thirdobj = obj.get(2);
        Map<String, Object> fourtobject = obj.get(3);
        System.out.println("First object" + firstobj);
        System.out.println(secondobj);
        System.out.println(thirdobj);
        System.out.println(fourtobject);


    }

    @Given("I want to display all the list of objects one by one")
        public void listOfObjects(){
        List<Map<String,Object>> object =response.jsonPath().getList("");
        System.out.println("first object: "+object.get(0));
        System.out.println("second object: "+object.get(1));
        System.out.println("third object: "+object.get(2));
        System.out.println("fourth object: "+object.get(3));

        }


    @And("I want to get the first id")
    public void iWantToGetTheFirstId() {
        List<Map<String,Object>> object =response.jsonPath().getList("");
        Object o = object.get(0).get("id");
        System.out.println(o);


    }

    @And("I want to print the reposnse")
    public void iWantToPrintTheReposnse() {
        String s = response.prettyPrint();
        System.out.println(s);

    }

    @And("Need company id along with owner id")
    public void needCompanyIdAlongWithOwnerId() {
       List<Map<String,Object>> object = response.jsonPath().getList("");

       // will iterate the object one by one and get the id
        for(Map<String,Object> obj:object) {
          Long id =  Long.valueOf(obj.get("id").toString());
            Object owner = obj.get("owner");
            Map<String,Object> ownerdata = (Map<String,Object>)owner;
            System.out.println("id of company: " +id + " ownerid: " +ownerdata.get("id"));
        }
    }

    @When("I want data of viewed attributes without hitting viewed data")
    public void  viewedAttribute(){
       List<Map<String,Object>> list  =response.jsonPath().getList("");
       for(Map<String,Object> object:list){
           Object viewed = object.get("viewed");
           System.out.println(viewed);
           System.out.println("********************");

           }
       }

    @And("I want viewer_id where time has some particular value")
    public void iWantViewer_idWhereTimeHasSomeParticularValue() {
       List<Map<String,Object>> list = response.jsonPath().getList("");
       for(Map<String,Object> object:list ){
           Object vieweddata = object.get("viewed");
           Map<String,Object> viewdatamapconversion = (Map<String,Object>)vieweddata;
           String viewedtime = viewdatamapconversion.get("viewed_time").toString();
           String viewer_id = viewdatamapconversion.get("viewer_id").toString();
           System.out.println(viewedtime+ " "+viewer_id);
          if(viewedtime.equals("viewed_time")){
               System.out.println("get me the viewer_id: "+viewer_id);
           }
           else
               System.out.println("test case is failed");

       }
    }

    @Given("I setup the request structure to create company")
    public void iSetupTheRequestStructureToCreateCompany(Map<String,String> testData) {

         name = testData.get("compName");
         url = testData.get("url");
        specification = RestAssured.given();
        String reqBody = "{\n" +
                "    \"type\": \"COMPANY\",\n" +
                "    \"star_value\": 4,\n" +
                "    \"lead_score\": 120,\n" +
                "    \"tags\": [],\n" +
                "    \"properties\": [\n" +
                "        {\n" +
                "            \"name\": \"Company Type\",\n" +
                "            \"type\": \"CUSTOM\",\n" +
                "            \"value\": \"MNC Inc\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"SYSTEM\",\n" +
                "            \"name\": \"name\",\n" +
                "            \"value\": \""+name+"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"SYSTEM\",\n" +
                "            \"name\": \"url\",\n" +
                "            \"value\": \""+url+"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        specification.baseUri("https://crmapiautomation.agilecrm.com")
                .basePath("/dev/api")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(reqBody)
                .auth().basic("varinderQA@yopmail.com", "g3a1j73r9dv1vsr5oca3gfmmh3")
                .log().all();
    }

    @When("I hit an api to create company")
    public void iHitAnApiToCreateCompany() {
        response = specification.post("/contacts");
    }

    @Then("I verify company created successfully")
    public void iVerifyCompanyCreatedSuccessfully() {

        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());

        List<Map<String,String>> propList = response.jsonPath().getList("properties");

        for (Map<String,String> propObj : propList){
            if(propObj.get("name").equals("name")){
                Assert.assertEquals(name, propObj.get("value"));
                System.out.println("successfully verified name of the company");
            }else if(propObj.get("name").equals("url")){
                Assert.assertEquals(url, propObj.get("value"));
                System.out.println("successfully verified url of the company");
            }

        }

    }
}









