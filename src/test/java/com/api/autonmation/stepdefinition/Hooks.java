package com.api.autonmation.stepdefinition;

import io.cucumber.java.*;

public class Hooks {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("This is before all global hook");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("This is after all global hook");

    }

    //scenario hook
    @Before
    public void beforeSH(){
        System.out.println("This is before scenario hook method");
    }

    //conditional hook
    @Before("@sanity")
    public void beforeCH(){
        System.out.println("This is before conditional hook method..");
    }

    @After("@sanity")
    public void afterCH(){
        System.out.println("This is after conditional hook method..");
    }
    @After
    public void afterSH(){
        System.out.println("This is after scenario hook method");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("This is before step hook method");

    }
    @AfterStep
    public void afterStep(){
        System.out.println("This is after scenario hook method");
    }
}
